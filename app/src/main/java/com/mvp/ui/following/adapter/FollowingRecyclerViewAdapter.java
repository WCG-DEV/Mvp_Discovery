package com.mvp.ui.following.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvp.R;
import com.mvp.net.UserInfo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cfp on 16-4-29.
 */
public class FollowingRecyclerViewAdapter extends RecyclerView.Adapter<FollowingRecyclerViewAdapter.FollowTextViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;

    private List<UserInfo> followings;

    public FollowingRecyclerViewAdapter(Context context, List<UserInfo> followings) {
        this.mContext = context;
        this.followings = followings;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public FollowTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FollowTextViewHolder(mInflater.inflate(R.layout.item_following, parent, false));
    }

    @Override
    public void onBindViewHolder(FollowTextViewHolder holder, int position) {
        holder.username_tv.setText(followings.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return followings == null ? 0 : followings.size();
    }

    public static class FollowTextViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.following_name)
        TextView username_tv;

        public FollowTextViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("FollowingRecycler", "onclick--> position" + getLayoutPosition());
                }
            });
        }
    }
}
