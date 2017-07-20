package com.jing.sszyt2.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.jing.sszyt2.Json.WriteJson;
import com.jing.sszyt2.R;
import com.jing.sszyt2.Util.OkHttpClientManager;
import com.jing.sszyt2.domain.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    // 变量 ******************************************************
    private EditText etID=null;
    private EditText etPwd=null;
    private String username="";
    private String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // 自定义方法*****************************************************
    //登录
    public void btnLogin_Login_Click(View view)
    {
        //boolean b=false;

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
        username=id;
        password=pwd;

        Log.d("前台值", username+" "+password);

      /*  User user = new User(username, password);
        构造一个user对象
        List<User> list = new ArrayList<User>();
        list.add(user);
        WriteJson writeJson = new WriteJson();
        将user对象写出json形式字符串
        String jsonString = writeJson.getJsonData(list);*/

        String url = "https://www.team539.cn/SSZYT/servlet/Login";

        OkHttpClientManager.postAsyn(url, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(String u) {
             //   Log.d("返回结果",u);
                if(u.equals("nouname")){
                    Toast.makeText(LoginActivity.this, "用户不存在", Toast.LENGTH_SHORT).show();
                }
                else if(u.equals("nopwd")){
                    Toast.makeText(LoginActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                }
                else{
                    String[] res=u.split(" ");
                    //进入主页面
                    goMain(username,res[1],MainActivity.class);
                    /*if(res[1].equals("teacher")){
                        //进入主页面
                        goMain(username,res[1],MainActivity.class);
                    }
                    if(res[1].equals("student")){
                        //进入学生页面
                        //goMain(username,res[1],MainActivity2.class);
                    }*/
                }
            }
        }, new OkHttpClientManager.Param("username", username),
                new OkHttpClientManager.Param("password", password));

    }
    //注册事件
    public void btnRegister_Login_Click(View view)
    {
        Toast.makeText(this, "请上官网注册！", Toast.LENGTH_LONG).show();
    }

    //页面跳转
    public void goMain(String username,String role,Class c){
        Intent intent=new Intent(LoginActivity.this,c);
        //用Bundle携带数据
        Bundle bundle=new Bundle();
        //传递name参数为username
        bundle.putString("username", username);
        bundle.putString("role", role);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
