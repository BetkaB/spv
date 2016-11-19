package com.example.beebzb.codingkid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CommandAdapter extends ArrayAdapter<Command> {

    public interface AdapterCallbacks {

        void onCommandCanceled(int position);

    }

    private Context context;
    private List<Command> mData = new ArrayList<>();
    private static LayoutInflater inflater = null;
    private AdapterCallbacks callbacks;

    public CommandAdapter(Context context, List<Command> data, AdapterCallbacks callbacks) {
        super(context, R.layout.item_command, data);
        this.context = context;
        this.mData = data;
        this.callbacks = callbacks;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Command> data) {
        mData = data;
        notifyDataSetChanged();
        Log.e("ADAPTER", data.toString());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Command getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.item_command, null);

        TextView text = (TextView) vi.findViewById(R.id.command_text);
        text.setAllCaps(true);
        text.setText(context.getString(mData.get(position).getStringId()));

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) text.getLayoutParams();
        params.leftMargin = 0;
        Command command = getItem(position);
        if (isInsideOfLoop() && command != Command.LOOP_END && command != Command.LOOP_START) {
            params.leftMargin = (int) context.getResources().getDimension(R.dimen.code_commands_margin);

        }
        text.setLayoutParams(params);

        ImageButton cancelBtn = (ImageButton) vi.findViewById(R.id.cancel_button);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbacks.onCommandCanceled(position);
            }
        });

        return vi;
    }

    private boolean isInsideOfLoop() {
        int start = 0;
        int end = 0;
        for (Command command : mData) {
            if (command == Command.LOOP_START) {
                start++;
            } else if (command == Command.LOOP_END) {
                end++;
            }
        }
        return start >= end;
    }
}