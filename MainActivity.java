package com.example.acer.demo04;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.acer.demo04.gen.PeopleDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button age;
    private Button sex;
    private RecyclerView recycler;
    private PeopleDao peopleDao;
    private RecycleAdapter adapter;
    private List<People> peopleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
        initAdapter();

    }

    private void initAdapter() {
        peopleList = peopleDao.loadAll();
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        adapter = new RecycleAdapter(peopleList, MainActivity.this);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initdata() {

        peopleDao = App.getApplication().getDaoSession().getPeopleDao();
        for (int i = 0; i < 10; i++) {
            People p=new People();
            p.setName("张三"+i);
            p.setAge("2"+i);
            p.setSex("男");
            peopleDao.insert(p);
        }
        initAdapter();
    }

    private void initView() {
        age = (Button) findViewById(R.id.age);
        sex = (Button) findViewById(R.id.sex);
        recycler = (RecyclerView) findViewById(R.id.recycler);

        age.setOnClickListener(this);
        sex.setOnClickListener(this);
    }
//创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,"添加");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.age:
                List<People> list = peopleDao.queryBuilder().where(PeopleDao.Properties.Age.eq("20")).list();

                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recycler.setLayoutManager(manager);
                RecycleAdapter recycleAdapter = new RecycleAdapter(list, MainActivity.this);
                recycler.setAdapter(recycleAdapter);
                break;
            case R.id.sex:
                List<People> people = peopleDao.queryBuilder().where(PeopleDao.Properties.Sex.eq("女")).list();
                LinearLayoutManager manager1 = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recycler.setLayoutManager(manager1);
                RecycleAdapter recycleAdapter1 = new RecycleAdapter(people, MainActivity.this);
                recycler.setAdapter(recycleAdapter1);
                break;
        }
    }
}
