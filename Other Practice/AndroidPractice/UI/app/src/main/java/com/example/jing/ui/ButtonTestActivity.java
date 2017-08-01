package com.example.jing.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonTestActivity extends AppCompatActivity implements View.OnClickListener
{
    // 函数重载 *******************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttontest_layout);

        Button button2 = (Button)findViewById(R.id.btnButtonTestButton2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(ButtonTestActivity.this,"button2单击",Toast.LENGTH_LONG).show();
            }
        });

        Button button3 = (Button)findViewById(R.id.btnButtonTestButton3);
        button3.setOnClickListener(this);

    }

    // 单击
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnButtonTestButton3:
                Toast.makeText(ButtonTestActivity.this,"button3单击",Toast.LENGTH_LONG).show();
                break;

        }

    }

    // 函数自定义 ******************************************************************
    public static void actionStart(Context context)
    {
        Intent intent = new Intent(context,ButtonTestActivity.class);
        context.startActivity(intent);
    }

    // 函数事件 *******************************************************************
    public void btnButtonTestButton1_Click(View view)
    {
        Toast.makeText(ButtonTestActivity.this,"button1单击",Toast.LENGTH_LONG).show();
    }

}
