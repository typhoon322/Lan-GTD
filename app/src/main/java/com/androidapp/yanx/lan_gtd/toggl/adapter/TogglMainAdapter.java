package com.androidapp.yanx.lan_gtd.toggl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.toggl.TogglTools;
import com.androidapp.yanx.lan_gtd.toggl.entity.ProjectEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * com.androidapp.yanx.lan_gtd.toggl.adapter
 * Created by yanx on 4/19/16 11:34 AM.
 * Description ${TODO}
 */
public class TogglMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ProjectEntity> datalist;

    private LayoutInflater inflater;

    private Context context;

    public TogglMainAdapter(List<ProjectEntity> datalist, Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        setDatalist(datalist);
    }

    public void setDatalist(List<ProjectEntity> datalist) {
        if (datalist == null) {
            datalist = new ArrayList<>();
        }
        this.datalist = datalist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.layout_item_toggl_main, parent, false);
        return new MainViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainViewHolder vh = (MainViewHolder) holder;
        ProjectEntity data = datalist.get(position);
        if (data != null) {
            vh.tvTitle.setText(data.getName());
            vh.tvDesc.setText(data.getAt());
            vh.viewColor.setBackgroundColor(TogglTools.getColorById(context, data.getColor()));
        }
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_title)
        TextView tvTitle;

        @Bind(R.id.view_color)
        View viewColor;

        @Bind(R.id.tv_desc)
        TextView tvDesc;

        public MainViewHolder(View itemView) {
            super(itemView);
            if (itemView != null) {
                ButterKnife.bind(this, itemView);
            }
        }
    }
}
