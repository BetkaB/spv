package com.example.beebzb.codingkid.screens.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.beebzb.codingkid.MainApplication;
import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.Utils;
import com.example.beebzb.codingkid.entity.MyActivity;
import com.example.beebzb.codingkid.entity.MyProgressDialog;
import com.example.beebzb.codingkid.module_preferences.Preferences;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends MyActivity implements GoogleApiClient.OnConnectionFailedListener {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        }
        context.startActivity(intent);
    }

    private static final String TAG = "SettingsActivity";
    private static final int RC_SIGN_IN = 9001;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    private GoogleApiClient mGoogleApiClient;

    private MyProgressDialog mProgressDialog;

    @Inject
    Preferences mPreferences;

    @BindView(R.id.settings_activity_user_status)
    TextView mStatusTextView;

    @BindView(R.id.settings_activity_sign_out_button)
    Button signOutButton;

    @BindView(R.id.settings_activity_google_sign_in_button)
    SignInButton signInButton;

    @BindView(R.id.settings_activity_teacher_radio_button)
    RadioButton teacherRadioButton;

    @BindView(R.id.settings_activity_student_radio_button)
    RadioButton studentRadioButton;

    @BindView(R.id.settings_activity_student_layout)
    LinearLayout studentLayout;

    @BindView(R.id.settings_activity_teacher_layout)
    LinearLayout teacherLayout;

    @BindView(R.id.settings_activity_id_input)
    EditText idInput;

    @BindView(R.id.settings_activity_signed_user_mail)
    TextView userMailLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        ((MainApplication) getApplication()).getComponent().injectSettingsActivity(this);

        initLayout();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    mPreferences.setUserEmail(user.getEmail());
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    mPreferences.setUserEmail(null);
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                updateUI(user);
            }
        };
    }

    private void initLayout() {
        mProgressDialog = new MyProgressDialog(this);
        checkRadioButtons();
    }

    private void checkRadioButtons() {
        if (mPreferences.isUserStudent()) {
            studentRadioButton.setChecked(true);
            teacherRadioButton.setChecked(false);
            signInButton.setEnabled(false);
            signOutButton.setEnabled(false);
            idInput.setEnabled(true);
        } else {
            studentRadioButton.setChecked(false);
            teacherRadioButton.setChecked(true);
            signInButton.setEnabled(true);
            signOutButton.setEnabled(true);
            idInput.setEnabled(false);
        }
    }

    @OnClick(R.id.settings_activity_student_radio_button)
    public void onStudentRadioButtonClicked() {
        mPreferences.setUserStudent(true);
        checkRadioButtons();
    }

    @OnClick(R.id.settings_activity_teacher_radio_button)
    public void onTeacherRadioButtonClicked() {
        mPreferences.setUserStudent(false);
        checkRadioButtons();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                updateUI(null);
            }
        }
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        mProgressDialog.setMessage(R.string.progress_dialog_message_signing_in);
        mProgressDialog.show();

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.e(TAG, "signInWithCredential", task.getException());
                            Utils.shortToast(SettingsActivity.this, R.string.settings_activity_authentication_failed);
                        }
                        mProgressDialog.hide();
                    }
                });
    }

    @OnClick(R.id.settings_activity_google_sign_in_button)
    public void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @OnClick(R.id.settings_activity_sign_out_button)
    public void signOut() {
        // Firebase sign out
        mAuth.signOut();
        // Google sign out
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        updateUI(null);
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if (mProgressDialog != null) {
            mProgressDialog.hide();
        }
        if (user != null) {
            userMailLabel.setText(user.getEmail());
            mStatusTextView.setText(getString(R.string.settings_activity_teacher_status, user.getEmail()));
            signInButton.setVisibility(View.GONE);
            signOutButton.setVisibility(View.VISIBLE);
        } else {
            mStatusTextView.setText(R.string.settings_activity_teacher_signed_out);
            signInButton.setVisibility(View.VISIBLE);
            signOutButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Utils.shortToast(this, R.string.settings_activity_connection_failed);
    }


}
