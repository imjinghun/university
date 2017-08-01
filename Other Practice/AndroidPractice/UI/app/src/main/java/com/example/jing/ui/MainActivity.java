package com.example.jing.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jing.ui.ButtonTestActivity;
import com.example.jing.ui.EditTextTestActivity;
import com.example.jing.ui.TextViewActivity;

public class MainActivity extends AppCompatActivity
{
    // 函数重载 *****************************************************************************
    // 创建
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

    // 创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return true;
    }

    // 菜单单击
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mnuMainAbout:
                AboutActivity.actionStart(MainActivity.this);
                break;
            case  R.id.mnuMainClose:
                finish();
                break;
        }

        return true;
    }

    // 函数事件 *******************************************************************
    // TextView
    public void btnMainTextView_Click(View view)
    {
        TextViewActivity.actionStart(MainActivity.this);
    }

    public void btnMainButtonTest_Click(View view)
    {
        ButtonTestActivity.actionStart(MainActivity.this);
    }

    public void btnMainEditTextTest_Click(View view)
    {
        EditTextTestActivity.actionStart(MainActivity.this);
    }

}
