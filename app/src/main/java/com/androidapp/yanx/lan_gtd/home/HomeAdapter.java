package com.androidapp.yanx.lan_gtd.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.RecycleOnItemClickListener;

import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/15/16 10:56 AM.
 * Description ${TODO}
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private List<MenuEntity> activities;

    private LayoutInflater inflater;

    private Context context;

    private RecycleOnItemClickListener onItemClickListener;

    public HomeAdapter(Context context, List<MenuEntity> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        setData(list);
    }

    public void setData(List<MenuEntity> list) {
        activities = list;
    }

    public RecycleOnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(RecycleOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.layout_item_home, parent, false);
        item.setOnClickListener(this);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder h = (ViewHolder) holder;
        h.btn_action.setText(activities.get(position).getTitle());
        h.itemView.setTag(activities.get(position).getClazz());
//        BackgroundColor(context.getResources().getColor(Tools.getRandomColorFromAppColor()));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.OnItemClick(view, view.getTag());
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        Button btn_action;

        public ViewHolder(View itemView) {
            super(itemView);
            if (itemView != null) {
                btn_action = (Button) itemView.findViewById(R.id.btn_action);
            }
        }
    }
}
