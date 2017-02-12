package com.example.beebzb.codingkid.screens.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.beebzb.codingkid.R;
import com.example.beebzb.codingkid.entity.Level;
import com.example.beebzb.codingkid.module_preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LevelAdapter extends ArrayAdapter<Level> {

    public interface AdapterCallbacks {

        void onLevelDeleted(int position);

    }

    private List<Level> mData = new ArrayList<>();

    public void setData(List<Level> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public Level getItem(int position) {
        return mData.get(position);
    }

    private Preferences mPreferences;
    private final AdapterCallbacks callbacks;

    public LevelAdapter(Context context, List<Level> data, AdapterCallbacks callbacks) {
        super(context, R.layout.listview_level_item, data);
        this.callbacks = callbacks;
        this.mData = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        MyViewHolder holder;
        if (convertView != null) {
            holder = (MyViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_level_item, viewGroup, false);
            holder = new MyViewHolder(convertView, getContext());
            convertView.setTag(holder);
        }

        Level level = getItem(position);
        holder.initItem(level);

        return convertView;
    }

    public class MyViewHolder {
        @BindView(R.id.listview_level_item_level_name)
        TextView levelNameLabel;

        private final Context mContext;

        private MyViewHolder(View view, Context context) {
            ButterKnife.bind(this, view);
            this.mContext = context;
        }

        public void initItem(Level level) {
            levelNameLabel.setText(level.getName());
        }
    }
}