package com.jing.helloworld;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    //变量***********************************************************************
    private TextView tvShow=null;
    private DB db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DB(this,"dbTest.db",null,1);
    }

    public void btnAddClick(View view)
    {
        EditText etname=(EditText)findViewById(R.id.etname);
        EditText etpwd=(EditText)findViewById(R.id.etpwd);
        SQLiteDatabase dbo=db.getWritableDatabase();
        String name=etname.getText().toString();
        String pwd=etpwd.getText().toString();
        String sql="insert into user values('"+name+"','"+pwd+"')";
        dbo.execSQL(sql);
        Toast.makeText(this,"添加成功",Toast.LENGTH_LONG).show();
    }

    public void btnDelClick(View view)
    {
        tvShow.setText("");
        new  AlertDialog.Builder(this)
                .setTitle("提示" )
                .setMessage("确定删除吗？" )
                .setPositiveButton("是" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText etname=(EditText)findViewById(R.id.etname2);
                        SQLiteDatabase dbo=db.getWritableDatabase();
                        String name=etname.getText().toString();
                        String sql="delete from user where name='"+name+"'";
                        dbo.execSQL(sql);
                    }})
                .setNegativeButton("否" , null)
                .show();
    }

    public void btnQueryClick(View view)
    {
        tvShow=(TextView)findViewById(R.id.tvShow);
        EditText etname=(EditText)findViewById(R.id.etname2);
        SQLiteDatabase dbo=db.getReadableDatabase();
        String name=etname.getText().toString();
        String sql="select * from user where name='"+name+"'";
        Cursor cursor;
        cursor=dbo.rawQuery(sql,null);
        if(cursor.moveToNext())
        {
            String n=cursor.getString(0);
            String p=cursor.getString(1);
            tvShow.setText("用户名："+n+"\r\n"+"爱好："+p);
        }
    }
}
