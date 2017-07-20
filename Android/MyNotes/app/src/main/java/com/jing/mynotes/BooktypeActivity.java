package com.jing.mynotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BooktypeActivity extends AppCompatActivity
{
    //变量 ******************************************************
    private DB db=null;
    private SQLiteDatabase dbo=null;
    private EditText etID=null;
    private EditText etName=null;
    private TextView tvResult=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktype);
        db=new DB(this, "dbMyNotes.db",null,1);
    }

    // 自定义方法 ***********************************************
    //添加
    public void btnAdd_Booktype_Click(View view)
    {
        String id,name;
        etID= (EditText) findViewById(R.id.etID_Booktype);
        etName= (EditText) findViewById(R.id.etName_Booktype);
        id=etID.getText().toString();
        name=etName.getText().toString();
        String sql="insert into booktype values('"+id+"','"+name+"')";
        dbo=db.getWritableDatabase();
        if(id.equals("")||name.equals(""))
        {
            Toast.makeText(this, "编号和名称均不可为空",Toast.LENGTH_SHORT).show();
            return;
        }
        try
        {
            dbo.execSQL(sql);
            Toast.makeText(this, "添加成功",Toast.LENGTH_SHORT).show();
        } catch (SQLException e)
        {
            Toast.makeText(this, "编号重复",Toast.LENGTH_SHORT).show();
        }
    }
    //删除
    public void btnDel_Booktype_Click(View view)
    {
        String id;
        etID= (EditText) findViewById(R.id.etID2_Booktype);
        id=etID.getText().toString();
        String sql="delete from booktype where btid='"+id+"'";
        dbo=db.getWritableDatabase();
        try
        {
            dbo.execSQL(sql);
            Toast.makeText(this, "删除成功",Toast.LENGTH_SHORT).show();
        } catch (SQLException e)
        {
            Toast.makeText(this, "编号不存在",Toast.LENGTH_SHORT).show();
        }
    }
    //按编号查询
    public void btnLook_Booktype_Click(View view)
    {
        String id;
        etID= (EditText) findViewById(R.id.etID2_Booktype);
        id=etID.getText().toString();
        String sql="select * from booktype where btid='"+id+"'";
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(sql,null);
        String strTemp="";
        if(cursor.moveToNext())
        {
            String strId,strName;
            strId=cursor.getString(0);
            strName=cursor.getString(1);
            strTemp+="编号："+strId+"\r\n名称："+strName;
        }
        else
        {
            Toast.makeText(this, "没有查到", Toast.LENGTH_SHORT).show();
        }
        tvResult=(TextView) findViewById(R.id.tvResult_Booktype);
        tvResult.setText(strTemp);

    }
    //查询所有
    public void btnLookAll_Booktype_Click(View view)
    {
        Intent intent = new Intent(this,BooktypeListActivity.class);
        startActivity(intent);
    }

}

