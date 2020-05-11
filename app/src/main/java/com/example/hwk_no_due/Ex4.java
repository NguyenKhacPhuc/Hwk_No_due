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
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutex4);
        reflectView();
        musicHolders = insertData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        listMusic.setLayoutManager(linearLayoutManager);
        MusicIn4Adapter musicIn4Adapter = new MusicIn4Adapter(musicHolders,getApplicationContext(),this);
        listMusic.setAdapter(musicIn4Adapter);

        //Set label quantity to the total number of songs
        quantity.setText(String.valueOf(musicHolders.size())+" Songs");
        //get total time
        for (int i = 0; i< musicHolders.size();i++){
           String duration = musicHolders.get(i).getDuration();
            convertToSecond(duration);
        }
        //display total time
        millis = totalSecond*1000;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        int seconds = (int)((millis / 1000) % 60);
        String timeString = String.valueOf(minutes)+":" + String.valueOf(seconds);
        timeCurrent.setText(timeString);

    }
    @Override
    public void onClick(int position) {
        //restart
        totalSecond = 0;
        millis = 0;
        seekBar.setProgress(0);

        //change main in4 to current track in4
        timeCurrent.setText(musicHolders.get(position).getDuration());
        String time = timeCurrent.getText().toString();
        tempDuration = time;

        convertToSecond(time);

        millis = totalSecond*1000;

        seekBar.setProgress(0);
        seekBar.setMax(totalSecond);
        Log.d("totalS",String.valueOf(totalSecond));
        playlistName.setText(musicHolders.get(position).getSongName());
        quantity.setText(musicHolders.get(position).getArtist());
        state.setImageResource(musicHolders.get(position).getThumbnail());

        if(countDownTimer != null){
            countDownTimer.cancel();
        }

         countDownTimer = new CountDownTimer(millis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //seek bar move forward
                int current = seekBar.getProgress();
                seekBar.setProgress(current+1);
                //back to 0 when reach to max
                if(seekBar.getProgress()==seekBar.getMax()){
                    seekBar.setProgress(0);
                }
                //reduce time label
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
    }

    public ArrayList<MusicHolder> insertData(){
        ArrayList<MusicHolder> musicHolders = new ArrayList<>();
        musicHolders.add(new MusicHolder(R.drawable.illenium,"Good things fall apart","Illenium","3:43",true));
        musicHolders.add(new MusicHolder(R.drawable.lana,"Flipside(Illenium remix)","Lana Del Rey","5:00",true));
        musicHolders.add(new MusicHolder(R.drawable.sharkmusic,"Oh Wonder(Illenium remix)","Shark","5:07",true));
        musicHolders.add(new MusicHolder(R.drawable.fractures,"Fractures","Illenium","4:06",false));
        musicHolders.add(new MusicHolder(R.drawable.gold,"Gold Dust(Illenium Remix)","Galantis","3:43",true));
        musicHolders.add(new MusicHolder(R.drawable.ascend,"In Your Arms","Illenium","4:11",true));
        musicHolders.add(new MusicHolder(R.drawable.lonely,"Lonely","Illenium","5:13",false));
        musicHolders.add(new MusicHolder(R.drawable.crahshing,"Crashing","Illenium","3:52",true));
        musicHolders.add(new MusicHolder(R.drawable.takeyoudown,"Take You Down","Illenium","3:50",true));
        return musicHolders;
    }
    public void reflectView(){
        listMusic = findViewById(R.id.listTrack);
        quantity = findViewById(R.id.quantity);
        timeCurrent = findViewById(R.id.timeCurrent);
        playlistName = findViewById(R.id.playlistName);
        state = findViewById(R.id.state);
        seekBar = findViewById(R.id.seekbar);
        musicHolders = new ArrayList<>();
    }
    public void convertToSecond(String duration){
        String[] s = duration.split(":");
        int minute = Integer.parseInt(s[0]);
        int remainSecond = Integer.parseInt(s[1]);
        totalSecond= totalSecond+minute*60+remainSecond;
    }
}
