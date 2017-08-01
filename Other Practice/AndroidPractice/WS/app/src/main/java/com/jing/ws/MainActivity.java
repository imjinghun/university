package com.jing.ws;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    // 成员变量 ********************************************************************
    EditText etID=null;
    TextView tvName=null;

    // 函数重载 ********************************************************************
    // 创建
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etID=(EditText)findViewById(R.id.etID);
        tvName=(TextView)findViewById(R.id.tvName);
    }

    // 函数自定义 ******************************************************************
    public void btnGetName_Click(View view)
    {

    }
}
