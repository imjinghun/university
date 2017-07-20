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

public class BookActivity extends AppCompatActivity
{
    //变量 ******************************************************
    private DB db = null;
    private SQLiteDatabase dbo = null;
    private EditText etID = null;
    private EditText etName = null;
    private EditText etAuthor = null;
    private EditText etPress = null;
    private EditText etISBN = null;
    private EditText etType = null;
    private TextView tvResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        db = new DB(this, "dbMyNotes.db", null, 1);
    }

    // 自定义方法 *********************************************************
    //添加书籍
    public void btnAdd_Book_Click(View view)
    {
        String id,name,author,press,isbn,type;
        etID= (EditText) findViewById(R.id.etID_Book);
        etName= (EditText) findViewById(R.id.etName_Book);
        etAuthor= (EditText) findViewById(R.id.etAuthor_Book);
        etPress= (EditText) findViewById(R.id.etPress_Book);
        etISBN= (EditText) findViewById(R.id.etISBN_Book);
        etType= (EditText) findViewById(R.id.etType_Book);

        id=etID.getText().toString();
        name=etName.getText().toString();
        author=etAuthor.getText().toString();
        press=etPress.getText().toString();
        isbn=etISBN.getText().toString();
        type=etType.getText().toString();

        String sql="insert into books values('"+id+"','"+name+"','"
                +author+"','"+press+"','"+isbn+"','"+type+"')";
        dbo=db.getWritableDatabase();
        if(id.equals(""))
        {
            Toast.makeText(this, "编号不可为空",Toast.LENGTH_SHORT).show();
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
    public void btnDel_Book_Click(View view)
    {
        String id;
        etID= (EditText) findViewById(R.id.etID2_Book);
        id=etID.getText().toString();
        String sql="delete from books where bid='"+id+"'";
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
    public void btnQuery_Book_Click(View view)
    {
        String id;
        etID= (EditText) findViewById(R.id.etID2_Book);
        id=etID.getText().toString();
        String sql="select * from books where bid='"+id+"'";
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(sql,null);
        String strTemp="";
        if(cursor.moveToNext())
        {
            String strId,strName,strAuthor,strPress,strISBN,strType;
            strId=cursor.getString(0);
            strName=cursor.getString(1);
            strAuthor=cursor.getString(2);
            strPress=cursor.getString(3);
            strISBN=cursor.getString(4);
            strType=cursor.getString(5);
            strTemp+="编号："+strId+"\r\n名称："+strName+"\r\n作者："+strAuthor
                    +"\r\n出版社："+strPress+"\r\nISBN："+strISBN+"\r\n分类ID："+strType;
        }
        else
        {
            Toast.makeText(this, "没有查到", Toast.LENGTH_SHORT).show();
        }
        tvResult=(TextView) findViewById(R.id.tvResult_Book);
        tvResult.setText(strTemp);

    }
    //查询所有
    public void btnQueryAll_Book_Click(View view)
    {
        Intent intent = new Intent(this,BookListActivity.class);
        startActivity(intent);
    }

}
