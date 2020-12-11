package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

     class MyThread extends Thread{ // не смог придумать другого способа, для обратного вызова первой активности через
     // определенный промежуток времени, получалось так что "засыпаят" вся активность
        public void run(){
            SystemClock.sleep(5000);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
    }

    ConstraintLayout root;
    TextView text;
    String enterLogin, enterPass;
    String currentLogin = "MrBrrown"; // верный логин
    String currentPass = "qwert123"; // верный пароль

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        root = findViewById(R.id.root2);
        text = findViewById(R.id.t1);

        Bundle arg = getIntent().getExtras();
        enterLogin = arg.getString("Login");
        enterPass = arg.getString("Password");

        if (currentLogin.equals(enterLogin) && currentPass.equals(enterPass)) {
            root.setBackgroundColor(Color.GREEN);
            text.setText(R.string.Successfuly);
        } else {
            root.setBackgroundColor(Color.RED);
            text.setText(R.string.Unsuccessfuly);
            MyThread thread = new MyThread();
            thread.start();
        }
    }
}
