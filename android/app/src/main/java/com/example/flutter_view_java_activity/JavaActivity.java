package com.example.flutter_view_java_activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class JavaActivity extends AppCompatActivity{
        @Override 
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_kotlin);
                getSupportActionBar().setTitle(R.string.title);
        }
}