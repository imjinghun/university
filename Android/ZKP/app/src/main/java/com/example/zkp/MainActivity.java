package com.example.zkp;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends ExpandableListActivity {

    DatabaseHelper helper= new DatabaseHelper(this);
    private Button btnback;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weeklist);

        //如果没有登录过，则进入登录界面
        SharedPreferences sp = this.getSharedPreferences("LoginData",Context.MODE_WORLD_READABLE);
        if(!sp.getBoolean("Judge",false))
        {
            Intent Intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(Intent);
            return;
        }
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

        //创建二级条目内容

        //周一课程
        Map<String, String> content_11 = new HashMap<String, String>();
        Map<String, String> content_12 = new HashMap<String, String>();

        content_11.put("child", queryInfo("112"));
        content_12.put("child", queryInfo("134"));

        List<Map<String, String>> childs_1 = new ArrayList<Map<String,String>>();
        childs_1.add(content_11);
        childs_1.add(content_12);

        //周二课程
        Map<String, String> content_21 = new HashMap<String, String>();
        Map<String, String> content_22 = new HashMap<String, String>();

        content_21.put("child", queryInfo("212"));
        content_22.put("child", queryInfo("234"));

        List<Map<String, String>> childs_2 = new ArrayList<Map<String,String>>();
        childs_2.add(content_21);
        childs_2.add(content_22);

        //周三课程
        Map<String, String> content_31 = new HashMap<String, String>();
        Map<String, String> content_32 = new HashMap<String, String>();

        content_31.put("child", queryInfo("312"));
        content_32.put("child", queryInfo("334"));

        List<Map<String, String>> childs_3 = new ArrayList<Map<String,String>>();
        childs_3.add(content_31);
        childs_3.add(content_32);

        //周四课程
        Map<String, String> content_41 = new HashMap<String, String>();
        Map<String, String> content_42 = new HashMap<String, String>();
        Map<String, String> content_43 = new HashMap<String, String>();

        content_41.put("child", queryInfo("412"));
        content_42.put("child", queryInfo("434"));
        content_43.put("child", queryInfo("456"));

        List<Map<String, String>> childs_4 = new ArrayList<Map<String,String>>();
        childs_4.add(content_41);
        childs_4.add(content_42);
        childs_4.add(content_43);

        //周五课程
        Map<String, String> content_51 = new HashMap<String, String>();
        Map<String, String> content_52 = new HashMap<String, String>();
        Map<String, String> content_53 = new HashMap<String, String>();

        content_51.put("child", queryInfo("512"));
        content_52.put("child", queryInfo("534"));
        content_53.put("child", queryInfo("556"));

        List<Map<String, String>> childs_5 = new ArrayList<Map<String,String>>();
        childs_5.add(content_51);
        childs_5.add(content_52);
        childs_5.add(content_53);

        //周六课程
        Map<String, String> content_6 = new HashMap<String, String>();
        content_6.put("child", "!!! No Classes !!!");
        List<Map<String, String>> childs_6 = new ArrayList<Map<String,String>>();
        childs_6.add(content_6);

        //周日课程
        Map<String, String> content_7 = new HashMap<String, String>();
        content_7.put("child", "!!! No Classes !!!");
        List<Map<String, String>> childs_7 = new ArrayList<Map<String,String>>();
        childs_7.add(content_7);

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

    //查询课表信息
    protected String queryInfo(String strid)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("my_kb", new String[]{"time","cour_name","classroom","week"}, "tid=?", new String[]{strid}, null, null, null);
        cursor.moveToFirst();
        String string=cursor.getString(0)+" | "+cursor.getString(1)+" | "+cursor.getString(2)+" | "+cursor.getString(3);
        return string;
    }
    /**************************************************************课表内容************************************************************/

    //按退出登录按钮返回登录界面
    class backListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
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
