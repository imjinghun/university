package com.example.jing.t2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity
{
    // 函数重载********************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    // 函数自定义*******************************************************************
    public void btnAboutClose(View view)
    {
        finish();
    }
}
