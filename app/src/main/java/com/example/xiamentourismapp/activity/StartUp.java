package com.example.xiamentourismapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.xiamentourismapp.R;
import com.example.xiamentourismapp.db.ConnectionProvider;

public class StartUp extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);

        //create database connection on startup
        ConnectionProvider.getConnection(this.getApplicationContext());

        //direct to LoginActivity
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(StartUp.this, Login.class));
            }
        },0);
    }
}