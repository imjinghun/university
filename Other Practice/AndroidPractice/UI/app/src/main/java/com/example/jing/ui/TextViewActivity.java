package com.example.jing.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TextViewActivity extends AppCompatActivity
{
    // 函数重载 *******************************************************************
    // 创建
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_layout);
    }

    // 函数自定义 ******************************************************************
    public static void actionStart(Context context)
    {
        Intent intent = new Intent(context,TextViewActivity.class);
        context.startActivity(intent);
    }





}
