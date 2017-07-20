package com.jing.mynotes;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{
    // 变量 ******************************************************
    private EditText etID=null;
    private EditText etPwd=null;
    private EditText etName=null;
    private DB db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        db=new DB(this,"dbMyNotes.db",null,1);
        setContentView(R.layout.activity_register);
    }

    //自定义方法 ************************************************
    //注册
    public void btnRegister_Register_Click(View view)
    {
        boolean b=false;
        SQLiteDatabase dbo=null;
        dbo=db.getWritableDatabase();

        etID= (EditText) findViewById(R.id.etID_Register);
        etPwd= (EditText) findViewById(R.id.etPwd_Register);
        etName= (EditText) findViewById(R.id.etName_Register);

        String id="",pwd="",name="";
        id= String.valueOf(etID.getText());
        pwd= String.valueOf(etPwd.getText());
        name= String.valueOf(etName.getText());

        if(id.equals("")||name.equals("")||pwd.equals(""))
        {
            Toast.makeText(this, "账号、密码、姓名均不可空", Toast.LENGTH_SHORT).show();
            b=false;
        }
        else
        {
            String sql="insert into user values('"+id+"','"+pwd+"','"+name+"')";
            try{
                dbo.execSQL(sql);
                b=true;
            }
            catch (Exception e){
                Toast.makeText(this, "账号已存在", Toast.LENGTH_SHORT).show();
            }
        }
        if(b==true)
        {
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }

}
