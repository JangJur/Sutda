package com.example.jur.sutda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class RoomActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<RoomInfo> foodInfoArrayList = new ArrayList<>();
        foodInfoArrayList.add(new RoomInfo(R.drawable.room, "함께해요~"));
        foodInfoArrayList.add(new RoomInfo(R.drawable.room, "매너겜 ㄱㄱ"));
        foodInfoArrayList.add(new RoomInfo(R.drawable.room, "신나게 놀자구~"));

        MyAdapter myAdapter = new MyAdapter(foodInfoArrayList);

        mRecyclerView.setAdapter(myAdapter);

    }

    public void makeRoom(View view) {
        Intent intent = new Intent(
                getApplicationContext(), // 현재 화면의 제어권자
                MakeRoom.class); // 다음 넘어갈 클래스 지정
        startActivity(intent); // 다음 화면으로 넘어간다
    }
}
