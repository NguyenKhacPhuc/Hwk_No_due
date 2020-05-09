package com.example.hwk_no_due;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageAdapterHolder> {
    private ArrayList<AnimalImage> animalImages;
    private Context context;
    public ImageAdapter(Context context, ArrayList<AnimalImage> animalImages){
        this.animalImages = animalImages;
        this.context = context;
    }
    @NonNull
    @Override
    public ImageAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView =inflater.inflate(R.layout.itemex3,parent,false);
        return new ImageAdapter.ImageAdapterHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return animalImages.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapterHolder holder, int position) {
        AnimalImage animalImage = animalImages.get(position);
        holder.quantity.setText(String.valueOf(animalImage.getNumberImage()));
        holder.image.setImageResource(animalImage.getResource());
        holder.name.setText(animalImage.getName());
        int heartSrc = 0;
        if(animalImage.isCheck()){
            heartSrc = R.drawable.like;
        }else{
            heartSrc = R.drawable.like;
        }
        holder.heart.setImageResource(heartSrc);
    }

    public class ImageAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        RelativeLayout rs;
        TextView name;
        TextView quantity;
        ImageView heart;
        public ImageAdapterHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            rs = (RelativeLayout) itemView.findViewById(R.id.in4holder);
            name = rs.findViewById(R.id.name);
            quantity = rs.findViewById(R.id.quantity);
            heart = rs.findViewById(R.id.heart);
            heart.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == heart.getId()){
                Toast.makeText(v.getContext(),"You have liked",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
