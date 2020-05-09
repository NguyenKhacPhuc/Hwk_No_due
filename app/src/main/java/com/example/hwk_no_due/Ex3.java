package com.example.hwk_no_due;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ex3 extends AppCompatActivity {
    private RecyclerView rs;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ex3);
        rs = findViewById(R.id.animalBoard);
        ArrayList<AnimalImage> animalImages = new ArrayList<>();

        animalImages.add(new AnimalImage(R.drawable.bear,"Bear",8,true));
        animalImages.add(new AnimalImage(R.drawable.chimpanzee,"Chimpanzee",8,true));
        animalImages.add(new AnimalImage(R.drawable.crow,"Crow",8,true));
        animalImages.add(new AnimalImage(R.drawable.fox,"Fox",8,true));
        animalImages.add(new AnimalImage(R.drawable.hen,"Hen",8,true));
        animalImages.add(new AnimalImage(R.drawable.horse,"Horse",8,true));
        animalImages.add(new AnimalImage(R.drawable.kitty,"Kitty",8,true));
        animalImages.add(new AnimalImage(R.drawable.monkey,"Monkey",8,true));
        animalImages.add(new AnimalImage(R.drawable.mouse,"Mouse",8,true));
        animalImages.add(new AnimalImage(R.drawable.panda,"Panda",8,true));
        animalImages.add(new AnimalImage(R.drawable.sheep,"Sheep",8,true));
        animalImages.add(new AnimalImage(R.drawable.tiger,"Tiger",8,true));
        animalImages.add(new AnimalImage(R.drawable.piggy,"Piggy",8,true));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        ImageAdapter imageAdapter = new ImageAdapter(this,animalImages);
        rs.setLayoutManager(gridLayoutManager);
        rs.setAdapter(imageAdapter);
    }
}
