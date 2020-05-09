package com.example.hwk_no_due;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicIn4Adapter extends RecyclerView.Adapter<MusicIn4Adapter.MusicIn4Holder> {
    private ArrayList<MusicHolder> musicHolders;
    private Context context;
    private MusicIn4Holder.onItemListener onItemListener;
    public MusicIn4Adapter(ArrayList<MusicHolder> musicHolders, Context context, MusicIn4Holder.onItemListener onItemListener){
        this.musicHolders = musicHolders;
        this.context = context;
        this.onItemListener = onItemListener;

    }
    @NonNull
    @Override
    public MusicIn4Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.itemex4,parent,false);
        return new MusicIn4Holder(itemView,onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicIn4Holder holder, int position) {
            MusicHolder mH = musicHolders.get(position);
            holder.songName.setText(mH.getSongName());
            holder.thumbnail.setImageResource(mH.getThumbnail());
            holder.artistName.setText(mH.getArtist());
            holder.duration.setText(mH.getDuration());
            if(!mH.isPlay()){
                holder.playic.setImageResource(R.drawable.ic_play);
            }
    }

    @Override
    public int getItemCount() {
        return musicHolders.size();
    }

    public static class MusicIn4Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView thumbnail;
        TextView songName;
        TextView artistName;
        TextView duration;
        ImageView playic;
        onItemListener onItemListener;
        public MusicIn4Holder(@NonNull View itemView, onItemListener onItemListener) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            songName = itemView.findViewById(R.id.songName);
            artistName = itemView.findViewById(R.id.artistName);
            duration = itemView.findViewById(R.id.duration);
            playic = itemView.findViewById(R.id.playic);
            this.onItemListener = onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemListener.onClick(getAdapterPosition());

        }
        public interface onItemListener{
            void onClick(int position);
        }
    }
}
