package com.jing.mynotes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BookListActivity extends AppCompatActivity
{
    //变量 ******************************************************
    private DB db=null;
    private TextView tvList=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklist);
        db=new DB(this, "dbMyNotes.db",null,1);
        btList();
    }
    public void btList()
    {
        tvList= (TextView) findViewById(R.id.tvList_BookList);

        String strSql="select * from books";
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(strSql,null);
        String strTemp="";
        while(cursor.moveToNext())
        {
            String strId,strName,strAuthor,strPress,strISBN,strType;

            strId=cursor.getString(0);
            strName=cursor.getString(1);
            strAuthor=cursor.getString(2);
            strPress=cursor.getString(3);
            strISBN=cursor.getString(4);
            strType=cursor.getString(5);

            strTemp+="编号："+strId+"\n名称："+strName+"\n作者："+strAuthor
                    +"\n出版社："+strPress+"\nISBN："+strISBN+"\n分类ID："+strType+"\n\n";
        }
        tvList.setText(strTemp);
    }
}
