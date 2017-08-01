package com.example.jing.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextTestActivity extends AppCompatActivity
{
    // 变量 *********************************************************************
    TextView tvInfo = null;
    EditText etName = null;

    // 函数重载 *******************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text_test_layout);

        tvInfo = (TextView)findViewById(R.id.tvEditTextTestInfo);
        etName = (EditText)findViewById(R.id.etEditTextTestName);
    }

    // 函数自定义 ******************************************************************
    public static void actionStart(Context context)
    {
        Intent intent = new Intent(context,EditTextTestActivity.class);
        context.startActivity(intent);
    }

    // 函数事件 *******************************************************************
    public void btnEditTextTestName_Click(View view)
    {
        String strName = "";
        strName = etName.getText().toString();
        tvInfo.setText("姓名: " + strName);
    }

}
