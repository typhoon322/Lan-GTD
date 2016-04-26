package com.androidapp.yanx.lan_gtd.gank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidapp.yanx.lan_gtd.DeviceUtil;
import com.androidapp.yanx.lan_gtd.ImageLoaderWrapper;
import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.gank.model.entity.GirlBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * com.androidapp.yanx.lan_gtd.gank
 * Created by yanx on 4/24/16 3:35 PM.
 * Description ${TODO}
 */
public class GankMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GirlBean> dataList;

    private LayoutInflater inflater;

    private Context context;

    private RelativeLayout.LayoutParams layoutParams;

    public GankMainAdapter(Context context, List<GirlBean> dataList) {
        inflater = LayoutInflater.from(context);
        setDataList(dataList);
        this.context = context;
        layoutParams = new RelativeLayout.LayoutParams(DeviceUtil.getScreenSize(context)[0], DeviceUtil.getScreenSize(context)[1]);
    }

    public void setDataList(List<GirlBean> dataList) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_gank_main, parent, false);
//        itemView.setLayoutParams(layoutParams);
        return new MainHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GirlBean itemData = dataList.get(position);
        MainHolder vh = (MainHolder) holder;
        ImageLoaderWrapper.showImage(context, vh.ivPortrait, itemData.getUrl());
        vh.tvTitle.setText(itemData.getType() + "  " + itemData.getDesc());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MainHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_portrait)
        ImageView ivPortrait;

        @Bind(R.id.tv_title)
        TextView tvTitle;

        public MainHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            ivPortrait.setLayoutParams(layoutParams);
        }
    }
}
