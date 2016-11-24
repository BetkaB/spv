package com.example.beebzb.codingkid;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CommandAdapter extends ArrayAdapter<Command> {

    public interface AdapterCallbacks {

        void onCommandCanceled(int position);

        void onLoopIterationChange(int position, int newValue);
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

        MyViewHolder holder;
        if (convertView != null) {
            holder = (MyViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_command, parent, false);
            holder = new MyViewHolder(convertView, getItem(position), position);
            convertView.setTag(holder);

        }
        holder.init(getItem(position), position);

        return convertView;
    }

    private boolean isInsideOfLoop() {
        int start = 0;
        int end = 0;
        for (Command command : mData) {
            CommandType commandType = command.getmCommandType();
            if (commandType == CommandType.LOOP_START) {
                start++;
            } else if (commandType == CommandType.LOOP_END) {
                end++;
            }
        }
        return start >= end;
    }

    public class MyViewHolder {
        @BindView(R.id.command_text)
        TextView labelText;

        @BindView(R.id.command_x)
        TextView labelX;

        @BindView(R.id.command_number)
        TextView labelNumber;

        @BindView(R.id.button_decrease)
        ImageButton btnDecrease;

        @BindView(R.id.button_increase)
        ImageButton btnIncrease;

        @BindView(R.id.button_cancel)
        ImageButton cancelBtn;

        private int position;

        private Command command;

        private MyViewHolder(View view, Command command, int position) {
            ButterKnife.bind(this, view);
            init(command, position);
        }

        private void init(Command command, int position) {
            this.position = position;
            this.command = command;
            labelText.setText(context.getString(command.getmCommandType().getStringId()));

            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) labelText.getLayoutParams();
            params.leftMargin = 0;
            CommandType commandType = command.getmCommandType();
            if (isInsideOfLoop() && commandType != CommandType.LOOP_END && commandType != CommandType.LOOP_START) {
                params.leftMargin = (int) context.getResources().getDimension(R.dimen.code_commands_margin);

            }
            labelText.setLayoutParams(params);


            if (commandType == CommandType.LOOP_START) {
                setVisibility(View.VISIBLE);
                labelNumber.setText(String.valueOf(command.getCount()));
            } else {
                setVisibility(View.GONE);
            }

        }

        private void setVisibility(int mode) {
            btnDecrease.setVisibility(mode);
            btnIncrease.setVisibility(mode);
            labelX.setVisibility(mode);
            labelNumber.setVisibility(mode);
        }

        @OnClick(R.id.button_cancel)
        public void onCancelClicked() {
            callbacks.onCommandCanceled(position);
        }

        @OnClick(R.id.button_increase)
        public void onIncreaseClicked() {
            int newValue = command.getCount() + 1;
            callbacks.onLoopIterationChange(position, newValue);
        }

        @OnClick(R.id.button_decrease)
        public void onDecreaseClicked() {
            int newValue = command.getCount() - 1;
            if (newValue > 0) {
                callbacks.onLoopIterationChange(position, newValue);
            }

        }
    }
}