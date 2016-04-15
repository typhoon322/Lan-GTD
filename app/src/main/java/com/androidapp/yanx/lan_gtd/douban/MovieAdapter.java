package com.androidapp.yanx.lan_gtd.douban;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidapp.yanx.lan_gtd.DeviceUtil;
import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.douban.entity.MovieItem;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * com.androidapp.yanx.lan_gtd.douban
 * Created by yanx on 4/15/16 1:50 PM.
 * Description ${TODO}
 */
public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    RecyclerView.LayoutParams layoutParams;
    private Activity mActivity;
    private List<MovieItem> movieList;
    private LayoutInflater inflater;

    public MovieAdapter(Activity mActivity, List<MovieItem> movieList) {
        layoutParams = new RecyclerView.LayoutParams((int) (DeviceUtil.getScreenSize(mActivity)[0] / 2), (int) (DeviceUtil.getScreenSize(mActivity)[1] / 2));
        inflater = LayoutInflater.from(mActivity);
        this.mActivity = mActivity;
        setData(movieList);
    }

    public void setData(List<MovieItem> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        movieList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.layout_item_movie, parent, false);
        itemView.setLayoutParams(layoutParams);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieItem movie = movieList.get(position);
        MovieViewHolder vh = (MovieViewHolder) holder;
        Glide.with(mActivity)
                .load(movie.getImages().getLarge())
                .centerCrop()
                .into(vh.ivPost);
        vh.tvTitle.setText(movie.getTitle());
        vh.tvActor.setText("" + position);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPost;
        TextView tvTitle;
        TextView tvActor;

        public MovieViewHolder(View itemView) {
            super(itemView);
            if (itemView != null) {
                ivPost = (ImageView) itemView.findViewById(R.id.iv_post);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                tvActor = (TextView) itemView.findViewById(R.id.tv_actor);
            }
        }
    }
}
