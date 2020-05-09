package com.example.hwk_no_due;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends BaseAdapter {
    private ArrayList<Feed> data;
    private LayoutInflater inflater;

    public Adapter(Context context, ArrayList<Feed> data){
        this.data = data;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View childView = convertView;

        FeedHolder holder = null;
        // Test ListView performance
        String identifier = convertView != null ? String.valueOf(convertView.hashCode()) : null;
        Log.i("[GET VIEW]", "getView " + position + " " + identifier);

        // Cache layout file to avoid inflating too many times
        if(convertView == null){
            // Get layout file
            childView = inflater.inflate(R.layout.item, parent, false);
            holder = new FeedHolder();

            holder.avatar = (CircleImageView)childView.findViewById(R.id.avatar);
            holder.image = (ImageView)childView.findViewById(R.id.image);
            holder.name = (TextView)childView.findViewById(R.id.username);
            holder.status = (TextView)childView.findViewById(R.id.status);
            holder.time = (TextView)childView.findViewById(R.id.time);
            holder.menu = (ImageView)childView.findViewById(R.id.menu_black);
            // Cache holder to childView to avoid findViewById too many times
            childView.setTag(holder);
        } else {
            holder = (FeedHolder) childView.getTag();
        }
        Feed feed = data.get(position);
        holder.avatar.setImageResource(feed.getAvatar());
        holder.menu.setImageResource(R.drawable.menu_black);
        holder.image.setImageResource(feed.getImage());
        holder.name.setText(feed.getUsername());
        holder.time.setText(feed.getTime());
        holder.status.setText(feed.getStatus());
        // Notify ListView that a row has been created and ready to be displayed
        return childView;
    }
    static class FeedHolder{
        CircleImageView avatar;
        ImageView image;
        TextView name;
        TextView status;
        TextView time;
        ImageView menu;
    }
}
