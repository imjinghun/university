package com.example.jing.dbtest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //变量***********************************************************************
    private TextView tvInfo=null;
    private DB db=null;

    //函数***********************************************************************
    //创建
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        tvInfo=(TextView)findViewById(R.id.tvMaininfo);
    }
    //函数事件*********************************************************************
    //创建数据库单击事件
    public void btnMainCreateDB_Click(View view)
    {
        Log.d("DBTest","MainActivity.btnMainCreateDB_Click()被调用");
        db=new DB(this,"dbTest.db",null,1);
        db.getReadableDatabase();
    }
    public void btnAdd_Click(View view)
    {
        String strSql="";
        strSql="insert into Student values('001','张三')";
        SQLiteDatabase dbo=null;
        dbo=db.getWritableDatabase();
        dbo.execSQL(strSql);
        Log.d("DBTest","插入数据1成功");
        strSql="insert into Student values('002','李四')";
        dbo.execSQL(strSql);
        Log.d("DBTest","插入数据2成功");
    }
    public void btnDelete_Click(View view)
    {
        String strSql="";
        strSql="delete from Student";
        SQLiteDatabase dbo=null;
        dbo=db.getWritableDatabase();
        dbo.execSQL(strSql);
        Log.d("DBTest","删除数据成功");
    }
    public void btnDisplay_Click(View view)
    {
        String strSql="";
        strSql="select * from Student";
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(strSql,null);

        String strTemp="";
        while(cursor.moveToNext())
        {
            String strID="",strName="";
            strID=cursor.getString(cursor.getColumnIndex("ID"));
            strName=cursor.getString(cursor.getColumnIndex("Name"));
            if(strTemp=="")
            {
                strTemp=strID+","+strName;
            }
            else
            {
                strTemp+="\r\n"+strID+","+strName;
            }

        }
        tvInfo.setText(strTemp);
        Log.d("DBTest","显示数据成功");
    }
}
