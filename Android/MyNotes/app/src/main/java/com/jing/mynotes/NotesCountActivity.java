package com.jing.mynotes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NotesCountActivity extends AppCompatActivity
{
    //变量 ******************************************************
    private DB db = null;
    private SQLiteDatabase dbo = null;
    private TextView tvNotesCount=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notescount);
        db = new DB(this, "dbMyNotes.db", null, 1);

        Bundle bundle = this.getIntent().getExtras();
        String btnName=bundle.getString("btnname");

        if(btnName.equals("btnAllNotes"))
        {
            NotesCount();
        }
        if(btnName.equals("btnUBNotes"))
        {
            UBNotesCount();
        }
        if(btnName.equals("btnLookNotes"))
        {
            AllNotes();
        }
    }

    // 自定义 *************************************************************
    //查询每位用户笔记数量
    public void NotesCount()
    {
        tvNotesCount= (TextView) findViewById(R.id.tvNotesCount);

        String strSql="select nuid,count(*) from notes group by nuid";
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(strSql,null);
        String strTemp="";
        while(cursor.moveToNext())
        {
            String uid,count;
            uid=cursor.getString(0);
            count=cursor.getString(1);
            strTemp+="用户编号："+uid+"\n笔记数量："+count+"\n\n";
        }
        tvNotesCount.setText(strTemp);
    }
    //查询每位用户每本书的笔记数量
    public void UBNotesCount()
    {
        tvNotesCount= (TextView) findViewById(R.id.tvNotesCount);

        String strSql="select nuid,nbtid,count(*) from notes group by nuid,nbtid";
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(strSql,null);
        String strTemp="";
        while(cursor.moveToNext())
        {
            String uid,bid,count;
            uid=cursor.getString(0);
            bid=cursor.getString(1);
            count=cursor.getString(2);
            strTemp+="用户编号："+uid+"\n书籍编号："+bid+"\n笔记数量："+count+"\n\n";
        }
        tvNotesCount.setText(strTemp);
    }
    //查询所有笔记
    public void AllNotes()
    {
        tvNotesCount= (TextView) findViewById(R.id.tvNotesCount);

        String strSql="select * from notes";
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(strSql,null);
        String strTemp="";
        while(cursor.moveToNext())
        {
            String uid,bid,date,content;
            uid=cursor.getString(0);
            bid=cursor.getString(1);
            date=cursor.getString(2);
            content=cursor.getString(3);
            strTemp+="用户编号："+uid+"\n书籍编号："+bid+"\n日期："+date+"\n内容："+content+"\n\n";
        }
        tvNotesCount.setText(strTemp);
    }
}
