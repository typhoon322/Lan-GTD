package com.androidapp.yanx.lan_gtd;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/26/16 9:51 PM.
 * Description ${TODO}
 */
public class RecycleBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected RecycleOnItemClickListener onItemClickListener;



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
