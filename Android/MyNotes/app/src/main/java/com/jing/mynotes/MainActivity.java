package com.jing.mynotes;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    // 函数重载 *******************************************************************
    // 创建
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_menu,menu);
        return true;
    }
    //菜单单击
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuhome:
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
                break;
            case R.id.menuAbout:
                AboutActivity.actionStart(MainActivity.this);
                break;
        }
        return true;
    }
    //自定义方法 *********************************************************
    //页面跳转
    public void actionStart(Class c)
    {
        Intent intent = new Intent(this,c);
        startActivity(intent);
    }

    //书籍分类管理
    public void btnBT_Main_Click(View view)
    {
        actionStart( BooktypeActivity.class);
    }
    //书籍管理
    public void btnBook_Main_Click(View view)
    {
        actionStart(BookActivity.class);
    }
    //我的读书笔记
    public void btnMyNotes_Main_Click(View view)
    {
        actionStart(NotesActivity.class);
    }
    //统计每位用户的笔记数量
    public void btnAllNotes_Main_Click(View view)
    {
        Intent intent = new Intent(this,NotesCountActivity.class);
        intent.putExtra("btnname","btnAllNotes");
        startActivity(intent);
    }
    //统计每位用户每本书的笔记数量
    public void btnUBNotes_Main_Click(View view)
    {
        Intent intent = new Intent(this,NotesCountActivity.class);
        intent.putExtra("btnname","btnUBNotes");
        startActivity(intent);
    }

}
