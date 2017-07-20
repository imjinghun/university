package com.jing.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jing on 2017/3/20.
 */

public class DB extends SQLiteOpenHelper
{
    //函数 **********************************************************************
    //构造
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        Log.d("DBTest","DB构造函数被调用");
    }

    //创建
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.d("DBTest","onCreate被调用");
        String strSql="";
        strSql="create table user ("
                +"name text null,"
                +"pdw text null,"
                +"primary key(name) )";
        db.execSQL(strSql);
        Log.d("DBTest","数据表user创建成功");
    }

    //升级
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        Log.d("DBTest","onUpgrade被调用");
    }
}
