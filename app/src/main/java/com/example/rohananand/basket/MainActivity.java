package com.example.rohananand.basket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ApplesQuant;
    private EditText OrangeQuant;
    private EditText BananaQuant;

    private EditText ApplesCost;
    private EditText OrangeCost;
    private EditText BananaCost;

    private CheckBox ApplesCheck;
    private CheckBox OrangeCheck;
    private CheckBox BananaCheck;

    private EditText TotalBill;
    private Button btnBill;

    private TextView UID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String user = intent.getStringExtra("user_name");
        UID = (TextView)findViewById(R.id.tvUserName);
        UID.setText("Hi " + user + "! What do you want to buy?");
        UID.setTextSize(16);
        addCheckBoxListener();
        addBtnBillListener();
    }

    public void addCheckBoxListener() {

        ApplesCheck = (CheckBox)findViewById(R.id.chkApples);
        ApplesQuant = (EditText)findViewById(R.id.etApplesQuant);

        ApplesCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ApplesCheck.isChecked()){
                    ApplesQuant.setText("1");
                    ApplesQuant.setEnabled(true);
                }
                else {
                    ApplesQuant.setEnabled(false);
                }
            }
        });

        OrangeCheck = (CheckBox)findViewById(R.id.chkOrange);
        OrangeQuant = (EditText)findViewById(R.id.etOrangesQuant);

        OrangeCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OrangeCheck.isChecked()){
                    OrangeQuant.setText("1");
                    OrangeQuant.setEnabled(true);
                }
                else {
                    OrangeQuant.setEnabled(false);
                }
            }
        });

        BananaCheck = (CheckBox)findViewById(R.id.chkBanana);
        BananaQuant = (EditText)findViewById(R.id.etBananaQuant);

        BananaCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(BananaCheck.isChecked()){
                    BananaQuant.setText("1");
                    BananaQuant.setEnabled(true);
                }
                else {
                    BananaQuant.setEnabled(false);
                }
            }
        });
    }

    public void addBtnBillListener(){
        btnBill = (Button)findViewById(R.id.btnBill);

        btnBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double apples_quant;
                double oranges_quant;
                double banana_quant;

                double apples_cost = 0;
                double oranges_cost = 0;
                double banana_cost = 0;

                if(ApplesCheck.isChecked()){
                    apples_quant = Double.parseDouble(ApplesQuant.getText().toString());
                    apples_cost = apples_quant * 42.5;

                }
                ApplesCost = (EditText)findViewById(R.id.etApplesCost);
                ApplesCost.setText(String.valueOf(apples_cost));

                if(OrangeCheck.isChecked()){
                    oranges_quant = Double.parseDouble(OrangeQuant.getText().toString());
                    oranges_cost = oranges_quant * 50.5;
                }
                OrangeCost = (EditText)findViewById(R.id.etOrangesCost);
                OrangeCost.setText(String.valueOf(oranges_cost));

                if(BananaCheck.isChecked()){
                    banana_quant = Double.parseDouble(BananaQuant.getText().toString());
                    banana_cost = banana_quant * 60;
                }
                BananaCost = (EditText)findViewById(R.id.etBananaCost);
                BananaCost.setText(String.valueOf(banana_cost));

                double total_bill = apples_cost + oranges_cost + banana_cost;
                TotalBill = (EditText)findViewById(R.id.etTotalBill);
                TotalBill.setText(String.valueOf(total_bill));
            }
        });
    }
}