package com.example.zkp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
    private EditText etus, etpw, etpw2;
    private Button btnreg;
    String pw, pw2,usna;
    DatabaseHelper helper= new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        etus = (EditText) findViewById(R.id.edittext1);
        etpw = (EditText) findViewById(R.id.edittext2);
        etpw2 = (EditText) findViewById(R.id.edittext3);
        btnreg = (Button) findViewById(R.id.reg);
        btnreg.setOnClickListener(new quListener());
    }

    class quListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            pw = etpw.getText().toString();
            pw2 = etpw2.getText().toString();
            usna = etus.getText().toString();
            SQLiteDatabase sdb = helper.getReadableDatabase();
            Cursor cursor = sdb.query("user", new String[]{"username"}, "username=?", new String[]{usna}, null, null, null);
            if(usna.equals("") || pw.equals("") || pw2.equals(""))
            {
                Toast.makeText(getApplicationContext(), "学号/密码/确认密码 不可为空",
                        Toast.LENGTH_SHORT).show();
            }
            else if(cursor.getCount()!=0){
                Toast.makeText(getApplicationContext(), "用户已存在",
                        Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (!pw.equals(pw2)) {
                    Toast.makeText(getApplicationContext(), "两次密码不一致", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try {
                        ContentValues values = new ContentValues();
                        values.put("username", usna);
                        values.put("password", pw);
                        sdb.insert("user", null, values);
                        Intent intent = new Intent(Register.this, LoginActivity.class);//进入登录界面
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "注册成功,请登录", Toast.LENGTH_SHORT).show();
                    }
                    catch (SQLiteException e) {
                        Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}