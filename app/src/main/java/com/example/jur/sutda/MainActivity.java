package com.example.jur.sutda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button01;
    private ArrayList<Integer> Card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game();


        // 버튼 이벤트 처리
        button01 = (Button) findViewById(R.id.button01);
    }
    public void game(){
        Card = new ArrayList<Integer>();

        for(int i=1; i<11; i++){
            Card.add(i);
            Card.add(i+10);
        }

        for(Integer el : Card) {
            Log.d("숫자", el + "\n");
        }
    }

    public void gameStart(View view) {
        startService(view);
        Intent intent = new Intent(
                getApplicationContext(), // 현재 화면의 제어권자
                NickName.class); // 다음 넘어갈 클래스 지정
        startActivity(intent); // 다음 화면으로 넘어간다
    }

    public void startService(View v) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
    public void stopService(View v) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}
