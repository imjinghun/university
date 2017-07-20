package com.jing.mynotes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    // 函数自定义 ******************************************************************
    // 启动
    public static void actionStart(Context context)
    {
        Intent intent=new Intent(context,AboutActivity.class);
        context.startActivity(intent);
    }
    //返回事件
    public void btnBack_About_Click(View view)
    {
        Intent intent = new Intent(AboutActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
