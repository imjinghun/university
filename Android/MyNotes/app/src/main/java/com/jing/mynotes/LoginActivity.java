package com.jing.mynotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    // 变量 ******************************************************
    private EditText etID=null;
    private EditText etPwd=null;
    private DB db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //创建数据库
        db=new DB(this,"dbMyNotes.db",null,1);
    }

    // 自定义方法*****************************************************
    //登录
    public void btnLogin_Login_Click(View view)
    {
        boolean b=false;
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();

        etID= (EditText) findViewById(R.id.etID_Login);
        etPwd= (EditText) findViewById(R.id.etPwd_Login);

        String id="",pwd="";
        id= String.valueOf(etID.getText());
        pwd= String.valueOf(etPwd.getText());
        if(id.equals("")||pwd.equals(""))
        {
            Toast.makeText(this, "账号/密码不可空", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean result=findUser(id,pwd);
        if(result==true)
        {
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "账号/密码不正确", Toast.LENGTH_SHORT).show();
        }
    }
    //注册事件
    public void btnRegister_Login_Click(View view)
    {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
    //查找账号是否存在
    public boolean findUser(String id,String pwd)
    {
        boolean b=false;
        String strSql="";
        strSql="select * from user where uid='"+id+"' and upwd='"+pwd+"'";
        SQLiteDatabase dbo=null;
        dbo=db.getReadableDatabase();
        Cursor cursor;
        cursor=dbo.rawQuery(strSql,null);
        if(cursor.moveToNext())
        {
            b=true;
        }
        return b;
    }

}
