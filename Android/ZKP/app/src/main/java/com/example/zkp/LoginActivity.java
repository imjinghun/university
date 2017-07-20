package com.example.zkp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoginActivity extends AppCompatActivity {
    private EditText etus, etpw;
    private Button btnlog,btnreg;
    DatabaseHelper helper= new DatabaseHelper(this);

    private String user;
    private String pswd;

    private static final String LOGIN_DATA="LoginData";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        etus = (EditText) findViewById(R.id.editText1);
        etpw = (EditText) findViewById(R.id.editText2);
        btnlog = (Button) findViewById(R.id.login);
        btnreg = (Button)findViewById(R.id.register);
        btnlog.setOnClickListener(new logListener());
        btnreg.setOnClickListener(new regListener());

        //自动输入最新登录成功的账号密码
        SharedPreferences loginData=getSharedPreferences(LOGIN_DATA,0);
        String username=loginData.getString("Username","");
        String password=loginData.getString("Password","");
        etus.setText(username);
        etpw.setText(password);
    }

    class regListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, Register.class);
            startActivity(intent);
        }
    }
    class logListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            user = etus.getText().toString();
            pswd = etpw.getText().toString();
            if (user.equals("") || pswd.equals(""))
            {
                Toast.makeText(getApplicationContext(), "用户名/密码不可为空！", Toast.LENGTH_SHORT).show();
            }
            else
            {
                sureuser(user, pswd);
            }
        }
    }

    private void sureuser(String uname, String pword) {

        try {
            SQLiteDatabase db = helper.getReadableDatabase();

            Cursor cursor = db.query("user", new String[]{"username","password"}, "username=?", new String[]{uname}, null, null, null);

            if(cursor.getCount()==0) //用户不存在
            {
                Toast.makeText(getApplicationContext(), "该用户不存在",
                        Toast.LENGTH_SHORT).show();
            }
            else //用户存在
            {
                cursor.moveToFirst();
                String pw=cursor.getString(1);
                if(pw.equals(pword)){ //登录成功
                    Toast.makeText(getApplicationContext(), "cg",
                            Toast.LENGTH_SHORT).show();
                    storage();//调用方法，保存账号密码
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);//进入课表界面
                    startActivity(intent);
                    android.os.Process.killProcess(android.os.Process.myPid());//销毁进程，否则从课表界面直接退出后，再次打开程序又进入了登录界面
                }
                else {
                    Toast.makeText(getApplicationContext(), "密码错误",
                            Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        }
        catch (SQLiteException e) {
            Toast.makeText(getApplicationContext(), "！！！哎呀 ！！出错了！！！",
                    Toast.LENGTH_SHORT).show();
        }
    }

    //如果登录成功，则保存当前用户名和密码
    private void storage(){
        SharedPreferences loginData=getSharedPreferences(LOGIN_DATA,0);
        Editor mEditor=loginData.edit();
        mEditor.putString("Username",etus.getText().toString());
        mEditor.putString("Password",etpw.getText().toString());
        mEditor.putBoolean("Judge",true);
        mEditor.commit();
    }
    //从登录界面退出时保存
    private void storage2(){
        SharedPreferences loginData=getSharedPreferences(LOGIN_DATA,0);
        Editor mEditor=loginData.edit();
        mEditor.putString("Username",etus.getText().toString()); /*试试去掉这两行*/
        mEditor.putString("Password", etpw.getText().toString());
        mEditor.putBoolean("Judge",false);
        mEditor.commit();
    }

    //按返回键退出程序回到桌面
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {

            if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }
            else
            {
                storage2();
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
