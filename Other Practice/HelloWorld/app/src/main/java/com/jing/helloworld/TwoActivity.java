package com.jing.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Bundle bundle = this.getIntent().getExtras();
        String name=bundle.getString("name");
        String pwd=bundle.getString("pwd");
        TextView tvname=(TextView)findViewById(R.id.tvname);
        TextView tvpwd=(TextView)findViewById(R.id.tvpwd);
        tvname.setText("用户名"+name);
        tvpwd.setText("密码"+pwd);
    }
}
