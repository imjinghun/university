package com.jing.mynotes;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesActivity extends AppCompatActivity
{
    //变量 ******************************************************
    private DB db = null;
    private SQLiteDatabase dbo = null;
    private EditText etUID=null;
    private EditText etBID=null;
    private EditText etContent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        db = new DB(this, "dbMyNotes.db", null, 1);
    }

    //自定义方法 **********************************************
    //添加
    public void btnAdd_Notes_Click(View view)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String strDate=formatter.format(curDate);

        etUID= (EditText) findViewById(R.id.etUID_Notes);
        etBID= (EditText) findViewById(R.id.etBID_Notes);
        etContent= (EditText) findViewById(R.id.etContent_Notes);

        String uid,bid,content;
        uid=etUID.getText().toString();
        bid=etBID.getText().toString();
        content=etContent.getText().toString();
        if(uid.equals("")||bid.equals(""))
        {
            Toast.makeText(this, "用户和书籍编号不可空", Toast.LENGTH_SHORT).show();
            return;
        }
        String sql="insert into notes values('"+uid+"','"+bid+"','"+strDate+"','"+content+"')";
        dbo=db.getWritableDatabase();
        try
        {
            dbo.execSQL(sql);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        } catch (SQLException e)
        {
            Toast.makeText(this, "主键重复", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    //查看所有笔记
    public void btnLookNotes_Notes_Click(View view)
    {
        Intent intent = new Intent(this,NotesCountActivity.class);
        intent.putExtra("btnname","btnLookNotes");
        startActivity(intent);
    }

}
