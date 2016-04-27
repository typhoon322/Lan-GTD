package com.androidapp.yanx.lan_gtd.gank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.RecycleOnItemClickListener;
import com.androidapp.yanx.lan_gtd.gank.model.entity.GanHuoBean;
import com.androidapp.yanx.lan_gtd.utils.FormatUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * com.androidapp.yanx.lan_gtd.gank.adapter
 * Created by yanx on 4/26/16 9:36 PM.
 * Description ${TODO}
 */
public class GanhuoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private List<GanHuoBean> dataList;

    private LayoutInflater inflater;

    private Context context;

    private RecycleOnItemClickListener onItemClickListener;

    public GanhuoListAdapter(Context context, List<GanHuoBean> dataList) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        setDataList(dataList);
    }

    public void setDataList(List<GanHuoBean> dataList) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_ganhuo_list, parent, false);
        view.setOnClickListener(this);
        return new GanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GanHuoBean itemData = dataList.get(position);
        if (itemData != null) {
            GanViewHolder vh = (GanViewHolder) holder;
            vh.tvContent.setText(itemData.getDesc());
            vh.tvAuthor.setText(FormatUtil.formatDate(itemData.getPublishedAt(), FormatUtil.FORMAT_3) + " by " + itemData.getWho());
            vh.itemView.setTag(itemData);
        }
    }


    public void setOnItemClickListener(RecycleOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.OnItemClick(view, view.getTag());
        }
    }

    class GanViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_desc)
        TextView tvContent;

        @Bind(R.id.tv_author)
        TextView tvAuthor;

        public GanViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
