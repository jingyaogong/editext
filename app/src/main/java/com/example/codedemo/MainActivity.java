package com.example.codedemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SerialnumberLayout verificationCode=findViewById(R.id.verification_code);
        verificationCode.setOnInputListener(new SerialnumberLayout.OnInputListener() {
            @Override
            public void onSucess(String code) {
                Toast.makeText(MainActivity.this,code,Toast.LENGTH_SHORT).show();
            }
        });
    }
}