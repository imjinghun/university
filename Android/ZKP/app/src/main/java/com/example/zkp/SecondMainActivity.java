package com.example.zkp;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import com.example.zkp.activity.HomeworkActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class SecondMainActivity extends ExpandableListActivity{
    DatabaseHelper helper= new DatabaseHelper(this);
    private Button btnback;
    private Button btnhomework;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weeklist);

        //如果没有登录过，则进入登录界面
        SharedPreferences sp = this.getSharedPreferences("LoginData",Context.MODE_WORLD_READABLE);
        if(!sp.getBoolean("Judge",false))
        {
            Intent Intent = new Intent(SecondMainActivity.this, LoginActivity.class);
            startActivity(Intent);
            return;
        }
        //添加作业按钮
        btnhomework = (Button)findViewById(R.id.homework);
        btnhomework.setOnClickListener(new homeworkListener());
        //返回登录界面
        btnback = (Button)findViewById(R.id.back);
        btnback.setOnClickListener(new backListener());

        /**************************************************************课表内容************************************************************/
        //创建二个一级条目标题
        Map<String, String> week_1 = new HashMap<String, String>();
        Map<String, String> week_2 = new HashMap<String, String>();
        Map<String, String> week_3 = new HashMap<String, String>();
        Map<String, String> week_4 = new HashMap<String, String>();
        Map<String, String> week_5 = new HashMap<String, String>();
        Map<String, String> week_6 = new HashMap<String, String>();
        Map<String, String> week_7 = new HashMap<String, String>();

        week_1.put("group", "周一");
        week_2.put("group", "周二");
        week_3.put("group", "周三");
        week_4.put("group", "周四");
        week_5.put("group", "周五");
        week_6.put("group", "周六");
        week_7.put("group", "周日");

        //创建一级条目容器
        List<Map<String, String>> gruops = new ArrayList<Map<String,String>>();

        gruops.add(week_1);
        gruops.add(week_2);
        gruops.add(week_3);
        gruops.add(week_4);
        gruops.add(week_5);
        gruops.add(week_6);
        gruops.add(week_7);

        //创建二级条目容器
        List<Map<String, String>> childs_1 = new ArrayList<Map<String,String>>();
        List<Map<String, String>> childs_2 = new ArrayList<Map<String,String>>();
        List<Map<String, String>> childs_3 = new ArrayList<Map<String,String>>();
        List<Map<String, String>> childs_4 = new ArrayList<Map<String,String>>();
        List<Map<String, String>> childs_5 = new ArrayList<Map<String,String>>();
        List<Map<String, String>> childs_6 = new ArrayList<Map<String,String>>();
        List<Map<String, String>> childs_7 = new ArrayList<Map<String,String>>();
        //存放内容, 以便显示在列表中
        List<List<Map<String, String>>> childs = new ArrayList<List<Map<String,String>>>();
        childs.add(childs_1);
        childs.add(childs_2);
        childs.add(childs_3);
        childs.add(childs_4);
        childs.add(childs_5);
        childs.add(childs_6);
        childs.add(childs_7);

        //创建ExpandableList的Adapter容器
        //参数: 1.上下文    2.一级集合	3.一级样式文件 4. 一级条目键值		5.一级显示控件名
        // 		6. 二级集合	7. 二级样式	8.二级条目键值	9.二级显示控件名
        SimpleExpandableListAdapter sela = new SimpleExpandableListAdapter(
                this, gruops, R.layout.weekgroup, new String[]{"group"}, new int[]{R.id.textGroup},
                childs, R.layout.weekchild, new String[]{"child"}, new int[]{R.id.textChild}
        );
        //加入列表
        setListAdapter(sela);
    }
    //按下课程，进入作业界面
    @Override
    public boolean onChildClick(ExpandableListView parent, View v,int groupPosition, int childPosition, long id)
    {
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }

    //二级标题按下
    @Override
    public boolean setSelectedChild(int groupPosition, int childPosition,
                                    boolean shouldExpandGroup)
    {
        // TODO Auto-generated method stub
        return super.setSelectedChild(groupPosition, childPosition, shouldExpandGroup);
    }

    //一级标题按下
    @Override
    public void setSelectedGroup(int groupPosition)
    {
        // TODO Auto-generated method stub
        super.setSelectedGroup(groupPosition);
    }
    /**************************************************************课表内容************************************************************/


    //按作业按钮进入作业记事界面
    class homeworkListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SecondMainActivity.this, HomeworkActivity.class);
            startActivity(intent);
        }
    }
    //按退出登录按钮返回登录界面
    class backListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SecondMainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    //实现按返回键退回桌面
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {
            if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else
            {
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
