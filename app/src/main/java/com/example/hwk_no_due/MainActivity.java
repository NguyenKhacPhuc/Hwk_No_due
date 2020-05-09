package com.example.hwk_no_due;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rs;
    private String status = "Mong dịch bệnh không quay đầu xe như Hải";
    private String name = "Nguyễn Khắc Phúc";
    private String date = "Today, 1:45PM";
    private int avatar = R.drawable.trap;
    private int image = R.drawable.picture;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
//        lv = (ListView)findViewById(R.id.dashboard);
        rs = (RecyclerView) findViewById(R.id.dashboard);
        ArrayList<Feed> feeds = new ArrayList<Feed>();
        feeds.add(new Feed(avatar,name,date,image,status));
        feeds.add(new Feed(avatar,name,date,image,status));
        feeds.add(new Feed(avatar,name,date,image,status));
        feeds.add(new Feed(avatar,name,date,image,status));
        feeds.add(new Feed(avatar,name,date,image,status));
//        Adapter adapter = new Adapter(this,feeds);
//        lv.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
        FeedAdapter feedAdapter = new FeedAdapter(this,feeds);
        rs.setLayoutManager(linearLayoutManager);
        rs.setAdapter(feedAdapter);

    }
}
