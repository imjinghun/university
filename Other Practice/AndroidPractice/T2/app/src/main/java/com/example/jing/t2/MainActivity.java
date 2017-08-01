package com.example.jing.t2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity
{
    //函数***********************************************************************
    //加载界面
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //加载菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // return super.onCreateOptionsMenu(menu);
        return true;
    }

    //单击菜单项
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.HigherAbout:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.HigherExit:
                finish();
                break;
        }
        return true;
    }

    //事件***********************************************************************
    //单击计算
    public void btnOk(View view)
    {
        EditText etF = (EditText) findViewById(R.id.etFather);
        EditText etM = (EditText) findViewById(R.id.etMother);
        TextView tvS = (TextView) findViewById(R.id.tvSon);
        TextView tvD = (TextView) findViewById(R.id.tvDaughter);

        //获取EditText值
        String strF = etF.getText().toString();
        String strM = etM.getText().toString();

        //设置显示格式保留一位小数 并且小数点前为0的话显示出来
        DecimalFormat df = new DecimalFormat("0.0");

        try
        {
            //String转换为double
            double dF = Double.valueOf(strF);
            double dM = Double.valueOf(strM);
            if (dF <= 0 || dM <= 0)
            {
                Toast.makeText(this, "请输入大于0的数字", Toast.LENGTH_SHORT).show();
            } else
            {
                //格式转换
                String ds = df.format((dF + dM) * 1.08 / 2);
                String dd = df.format((dF * 0.923 + dM) / 2);
                //显示到TextView
                tvS.setText(ds + "±5");
                tvD.setText(dd + "±5");
            }
        } catch (Exception ex)
        {
            Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
        }

    }

}
