package com.example.jur.sutda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NickName extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button button;
    private String nName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_name);

        textView = findViewById(R.id.tv);
        editText = findViewById(R.id.et);
        button = findViewById(R.id.btn);
    }

    public void nickName(View view) {
        String addr = "10.0.2.2";
        nName = editText.getText().toString();
        ConnectThread thread = new ConnectThread(addr);
        thread.start();

        Intent intent = new Intent(
                getApplicationContext(), // 현재 화면의 제어권자
                RoomActivity.class); // 다음 넘어갈 클래스 지정
        startActivity(intent); // 다음 화면으로 넘어간다
    }

    class ConnectThread extends Thread {
        String hostname;

        public ConnectThread(String addr) {
            hostname = addr;
        }

        public void run() {
            int port = 30000;

            Socket s = null;
            ObjectOutputStream os = null;
            ObjectInputStream is = null;
            try {
                s = new Socket(hostname, port);

                os = new ObjectOutputStream(s.getOutputStream());
                os.writeObject(nName);
                os.flush();

                is = new ObjectInputStream(s.getInputStream());
                String obj = (String) is.readObject();
                Log.d("MainActivity", "서버에서 받은 메시지 : " + obj);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    if (s != null) s.close();
                    if (is != null) is.close();
                    if (os != null) os.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
