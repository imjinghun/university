package com.jing.mynotes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BooktypeListActivity extends AppCompatActivity
{
    //变量 ******************************************************
    private DB db=null;
    private TextView tvList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktypelist);
        db=new DB(this, "dbMyNotes.db",null,1);
        btList();
    }
    public void btList()
    {
        tvList= (TextView) findViewById(R.id.tvList_BooktypeList);

        String strSql="select * from booktype";
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(strSql,null);
        String strTemp="";
        while(cursor.moveToNext())
        {
            String strId,strName;
            strId=cursor.getString(0);
            strName=cursor.getString(1);
            strTemp+="编号："+strId+"\n名称："+strName+"\n\n";
        }
        tvList.setText(strTemp);
    }
}
