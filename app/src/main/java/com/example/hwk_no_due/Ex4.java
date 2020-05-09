package com.example.hwk_no_due;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Ex4 extends AppCompatActivity implements MusicIn4Adapter.MusicIn4Holder.onItemListener{
    private RecyclerView listMusic;
    private TextView quantity;
    private TextView timeCurrent;
    private ArrayList<MusicHolder> musicHolders;
    private TextView playlistName;
    private ImageView state;
    private long millis;
    private int totalSecond ;
    private SeekBar seekBar;
    private String tempDuration;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutex4);
        listMusic = findViewById(R.id.listTrack);
        quantity = findViewById(R.id.quantity);
        timeCurrent = findViewById(R.id.timeCurrent);
        playlistName = findViewById(R.id.playlistName);
        state = findViewById(R.id.state);
        seekBar = findViewById(R.id.seekbar);
        musicHolders = new ArrayList<>();
        musicHolders.add(new MusicHolder(R.drawable.illenium,"Good things fall apart","Illenium","3:43",false));
        musicHolders.add(new MusicHolder(R.drawable.lana,"Flipside(Illenium remix)","Lana Del Rey","5:00",false));
        musicHolders.add(new MusicHolder(R.drawable.sharkmusic,"Oh Wonder(Illenium remix)","Shark","5:07",false));
        musicHolders.add(new MusicHolder(R.drawable.fractures,"Fractures","Illenium","4:06",false));
        musicHolders.add(new MusicHolder(R.drawable.gold,"Gold Dust(Illenium Remix)","Galantis","3:43",false));
        musicHolders.add(new MusicHolder(R.drawable.ascend,"In Your Arms","Illenium","4:11",false));
        musicHolders.add(new MusicHolder(R.drawable.lonely,"Lonely","Illenium","5:13",false));
        musicHolders.add(new MusicHolder(R.drawable.crahshing,"Crashing","Illenium","3:52",false));
        musicHolders.add(new MusicHolder(R.drawable.takeyoudown,"Take You Down","Illenium","3:50",false));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        listMusic.setLayoutManager(linearLayoutManager);
        MusicIn4Adapter musicIn4Adapter = new MusicIn4Adapter(musicHolders,getApplicationContext(),this);
        listMusic.setAdapter(musicIn4Adapter);
        quantity.setText(String.valueOf(musicHolders.size())+" Songs");

        for (int i = 0; i< musicHolders.size();i++){
           String duration = musicHolders.get(i).getDuration();
           String[] s = duration.split(":");
           int minute = Integer.parseInt(s[0]);
           int remainSecond = Integer.parseInt(s[1]);
           totalSecond= totalSecond+minute*60+remainSecond;
        }
        millis = totalSecond*1000;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        int seconds = (int)((millis / 1000) % 60);
        String timeString = String.valueOf(minutes)+":" + String.valueOf(seconds);
        timeCurrent.setText(timeString);

    }
    @Override
    public void onClick(int position) {
        totalSecond = 0;
        millis = 0;
        seekBar.setProgress(0);
        timeCurrent.setText(musicHolders.get(position).getDuration());
        String time = timeCurrent.getText().toString();
        tempDuration = time;
        String[] s = time.split(":");
        int minute = Integer.parseInt(s[0]);
        int remainSecond = Integer.parseInt(s[1]);
        totalSecond= totalSecond+minute*60+remainSecond;
        millis = totalSecond*1000;
        seekBar.setProgress(0);
        seekBar.setMax(totalSecond);
        Log.d("totalS",String.valueOf(totalSecond));
        playlistName.setText(musicHolders.get(position).getSongName());
        quantity.setText(musicHolders.get(position).getArtist());
        state.setImageResource(musicHolders.get(position).getThumbnail());
        CountDownTimer countDownTimer = new CountDownTimer(millis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int current = seekBar.getProgress();
                seekBar.setProgress(current+1);
                if(seekBar.getProgress()==seekBar.getMax()){
                    seekBar.setProgress(0);
                }
                millis = millis-1000;
                long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
                int seconds = (int)((millis / 1000) % 60);
                String timeString = String.valueOf(minutes)+":" + String.valueOf(seconds);
                timeCurrent.setText(timeString);
            }

            @Override
            public void onFinish() {

            }
        }.start();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
