package com.jing.sszyt2.Activity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.jing.sszyt2.R;
import com.jing.sszyt2.Util.OkHttpClientManager;
import com.squareup.okhttp.Request;
import com.jing.sszyt2.Json.JsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity
{
    // 变量 ******************************************************
    private TextView tvList=null;
    private String username="";
    private String role="";
    JsonUtil jsonUtil=new JsonUtil();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //新页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收username值
        username = bundle.getString("username");
        role = bundle.getString("role");
        tvList= (TextView) findViewById(R.id.tvList_BookList);
        Log.d("获取到  ",username+" "+role);
        showResult();
    }
    public void showResult(){
        String url = "https://www.team539.cn/SSZYT/servlet/AndroidQueryHW";

        OkHttpClientManager.postAsyn(url, new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String u) {
                       // Log.d("返回结果",u);
                        Map mapType = JSON.parseObject(u,Map.class);

                        List<Map<String,String>> list=jsonUtil.StringFromJson(mapType.get("list").toString());

                        String strTemp="";
                        for(int i=0;i<list.size();i++){
                            Map<String,String> maps=list.get(i);

                            String hname,hinfo,hendtime,hsubmit,hnosubmit;
                            hname=maps.get("hname");
                            hinfo=maps.get("hinfo");
                            hendtime=maps.get("hendtime");
                            strTemp+="名称："+hname+"\n内容："+hinfo+"\n截止时间："+hendtime;
                            if(role.equals("teacher")){
                                hsubmit=maps.get("hsubmit");
                                hnosubmit=maps.get("hnosubmit");
                                strTemp+="\n已交人数："+hsubmit+"\n未交人数："+hnosubmit;
                            }
                            strTemp+="\n==============\n\n";

                        }
                        tvList.setText(strTemp);
                    }
                }, new OkHttpClientManager.Param("username", username),
                new OkHttpClientManager.Param("role", role));
    }
}
