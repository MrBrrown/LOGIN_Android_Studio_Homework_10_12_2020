package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText loginField, passField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginField = findViewById(R.id.login);
        passField = findViewById(R.id.pass);
    }

    public void onLoginClick(View view){
        String log,pass;
        log = loginField.getText().toString();
        pass = passField.getText().toString();

        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
        intent.putExtra("Login",log);
        intent.putExtra("Password", pass);
        startActivity(intent);
        // Верные логии пароль объявленны в MainActivity2
    }
}