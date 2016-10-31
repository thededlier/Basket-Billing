package com.example.rohananand.basket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Splash extends AppCompatActivity {

    EditText userName;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        btnContinueListener();
    }

    public void btnContinueListener(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        userName = (EditText)findViewById(R.id.etUserName);
        String user = "Guest";
        if(userName.length() == 0)
            userName.setText("Guest");
//        btnContinue = (Button)findViewById(R.id.btnContinue);
        else
            user = userName.getText().toString();
        intent.putExtra("user_name", user);
        startActivity(intent);
    }
}
