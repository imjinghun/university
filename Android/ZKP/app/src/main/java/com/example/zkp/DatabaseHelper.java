package com.example.zkp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String dbname="people.db";

    private static final String tablename="user";

    private static final String tablename2="my_kb";

    private static final int version=1;

    public DatabaseHelper(Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1="create table"+" "+tablename+"(username varchar,password varchar)";
        db.execSQL(sql1);

        String sql2="create table"+" "+tablename2+"(tid varchar,wk varchar,cour_name varchar,teacher varchar,classroom varchar,week varchar,time varchar)";
        db.execSQL(sql2);

        insertUser(db);
        insertKb(db);
    }

    public void insertUser(SQLiteDatabase db)//插入四条数据
    {
        ContentValues values = new ContentValues();
        values.put("username", "20142861");
        values.put("password", "123456");
        db.insert("user", null, values);

        values.put("username", "20142872");
        values.put("password", "123456");
        db.insert("user", null, values);

        values.put("username", "20142928");
        values.put("password", "123456");
        db.insert("user", null, values);

        values.put("username", "20143048");
        values.put("password", "123456");
        db.insert("user", null, values);
    }

    public void insertKb(SQLiteDatabase db)//插入数据
    {
        ContentValues values = new ContentValues();

        values.put("tid", "112");
        values.put("wk", "周一");
        values.put("cour_name", "软件工程概论");
        values.put("teacher", "王建民");
        values.put("classroom", "基教301");
        values.put("week", "1-16周");
        values.put("time", "1-2节");
        db.insert("my_kb", null, values);

        values.put("tid", "134");
        values.put("wk", "周一");
        values.put("cour_name", "概率论与数理统计(A)");
        values.put("teacher", "赵士欣");
        values.put("classroom", "基教511");
        values.put("week", "1-16周");
        values.put("time", "3-4节");
        db.insert("my_kb", null, values);

        values.put("tid", "212");
        values.put("wk", "周二");
        values.put("cour_name", "计算机网络");
        values.put("teacher", "郭阳");
        values.put("classroom", "基教316");
        values.put("week", "1-16周");
        values.put("time", "1-2节");
        db.insert("my_kb", null, values);

        values.put("tid", "234");
        values.put("wk", "周二");
        values.put("cour_name", "数据库原理");
        values.put("teacher", "马新娜");
        values.put("classroom", "基教116");
        values.put("week", "1-12周");
        values.put("time", "3-4节");
        db.insert("my_kb", null, values);

        values.put("tid", "312");
        values.put("wk", "周三");
        values.put("cour_name", "大学英语");
        values.put("teacher", "张云岗");
        values.put("classroom", "二教101");
        values.put("week", "1-16周");
        values.put("time", "1-2节");
        db.insert("my_kb", null, values);

        values.put("tid", "334");
        values.put("wk", "周三");
        values.put("cour_name", "体育四");
        values.put("teacher", "杨永刚");
        values.put("classroom", "体育场");
        values.put("week", "1-16周");
        values.put("time", "3-4节");
        db.insert("my_kb", null, values);

        values.put("tid", "456");
        values.put("wk", "周四");
        values.put("cour_name", "概率论与数理统计(A)");
        values.put("teacher", "赵士欣");
        values.put("classroom", "基教511");
        values.put("week", "1-16周(单)");
        values.put("time", "5-6节");
        db.insert("my_kb", null, values);

        values.put("tid", "412");
        values.put("wk", "周四");
        values.put("cour_name", "计算机网络");
        values.put("teacher", "郭阳");
        values.put("classroom", "基教316");
        values.put("week", "1-16周");
        values.put("time", "1-2节");
        db.insert("my_kb", null, values);

        values.put("tid", "434");
        values.put("wk", "周四");
        values.put("cour_name", "数据库原理");
        values.put("teacher", "马新娜");
        values.put("classroom", "基教116");
        values.put("week", "1-12周");
        values.put("time", "3-4节");
        db.insert("my_kb", null, values);

        values.put("tid", "512");
        values.put("wk", "周五");
        values.put("cour_name", "大学英语");
        values.put("teacher", "张云岗");
        values.put("classroom", "二教101");
        values.put("week", "1-16周");
        values.put("time", "1-2节");
        db.insert("my_kb", null, values);

        values.put("tid", "534");
        values.put("wk", "周五");
        values.put("cour_name", "毛概1");
        values.put("teacher", "樊瑞科");
        values.put("classroom", "基教403");
        values.put("week", "1-16周");
        values.put("time", "3-4节");
        db.insert("my_kb", null, values);

        values.put("tid", "556");
        values.put("wk", "周五");
        values.put("cour_name", "WEB应用技术");
        values.put("teacher", "雷宇");
        values.put("classroom", "基教103");
        values.put("week", "1-8周");
        values.put("time", "5-6节");
        db.insert("my_kb", null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion>oldVersion)
        {
            String sql1="drop table if exists"+tablename;
            db.execSQL(sql1);
            String sql2="drop table if exists"+tablename2;
            db.execSQL(sql2);
            this.onCreate(db);
        }
    }
}

