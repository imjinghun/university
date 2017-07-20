package com.jing.mynotes;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jing on 2017/4/13.
 */

public class DB extends SQLiteOpenHelper
{
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        Log.d("MyNotesDB","DB构造函数被调用");
    }
    //创建
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.d("MyNotesDB","onCreate被调用");
        String strSql="";
        //书籍分类
        strSql="create table booktype ("
                +"btid text null,"
                +"btname text null,"
                +"primary key(btid) )";
        db.execSQL(strSql);
        Log.d("MyNotesDB","booktype表创建成功");

        //书籍
        strSql="create table books ("
                +"bid text primary key,"
                +"bname text null,"
                +"bauthor text null,"
                +"bpress text null,"
                +"bisbn text null,"
                +"bbt text,"
                +"FOREIGN KEY (bbt) REFERENCES booktype(btid))";
        try
        {
            db.execSQL(strSql);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        Log.d("MyNotesDB","books表创建成功");

        //用户
        strSql="create table user ("
                +"uid text primary key ,"
                +"upwd text,"
                +"uname text )";
        db.execSQL(strSql);
        Log.d("MyNotesDB","user表创建成功");

        //笔记
        strSql="create table notes ("
                +"nuid text not null ,"
                +"nbtid text not null ,"
                +"ndata text not null,"
                +"ncontent text null,"
                +"primary key(nuid,nbtid,ndata),"
                +"FOREIGN KEY (nuid) REFERENCES user(uid),"
                +"FOREIGN KEY (nbtid) REFERENCES booktype(btid))";
        db.execSQL(strSql);
        Log.d("MyNotesDB","notes表创建成功");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        Log.d("MyNotesDB","onUpgrade被调用");
    }
}
