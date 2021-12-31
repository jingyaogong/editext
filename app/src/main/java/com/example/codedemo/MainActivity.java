package com.example.codedemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gjylibrary.GjySerialnumberLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GjySerialnumberLayout verificationCode=findViewById(R.id.verification_code);
        verificationCode.setOnInputListener(new GjySerialnumberLayout.OnInputListener() {
            @Override
            public void onSucess(String code) {
                System.out.println(code);
            }
        });
    }
}