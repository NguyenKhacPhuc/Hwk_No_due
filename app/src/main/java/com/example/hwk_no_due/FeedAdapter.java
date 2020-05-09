package com.example.hwk_no_due;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {
    private ArrayList<Feed> feeds;
    private Context context;

    public FeedAdapter(Context context, ArrayList<Feed> feeds){
        this.feeds = feeds;
        this.context = context;
    }
    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView =inflater.inflate(R.layout.item,parent,false);
        return new FeedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedHolder holder, int position) {
            Feed feed = feeds.get(position);
            holder.avatar.setImageResource(feed.getAvatar());
            holder.menu.setImageResource(R.drawable.menu_black);
            holder.image.setImageResource(feed.getImage());
            holder.name.setText(feed.getUsername());
            holder.time.setText(feed.getTime());
            holder.status.setText(feed.getStatus());
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public class FeedHolder extends RecyclerView.ViewHolder{
        CircleImageView avatar;
        ImageView image;
        TextView name;
        TextView status;
        TextView time;
        ImageView menu;
        public FeedHolder(@NonNull View itemView) {
            super(itemView);
            avatar = (CircleImageView)itemView.findViewById(R.id.avatar);
            image = (ImageView)itemView.findViewById(R.id.image);
            name = (TextView)itemView.findViewById(R.id.username);
            status = (TextView)itemView.findViewById(R.id.status);
            time = (TextView)itemView.findViewById(R.id.time);
            menu = (ImageView)itemView.findViewById(R.id.menu_black);
        }
    }
}
