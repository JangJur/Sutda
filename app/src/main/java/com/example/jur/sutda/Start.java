package com.example.jur.sutda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    private Button button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // 버튼 이벤트 처리
        button01 = (Button) findViewById(R.id.button01);
    }

    public void gameStart(View view) {
        Intent intent = new Intent(
                getApplicationContext(), // 현재 화면의 제어권자
                NickName.class); // 다음 넘어갈 클래스 지정
        startActivity(intent); // 다음 화면으로 넘어간다
    }
}