package com.example.acer.demo04;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.acer.demo04.gen.PeopleDao;
//姚明亮弗兰克的感觉看；的任天野任天野rest有人童话故事犯桃花任天野任天野儿童
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText age;
    private EditText sex;
    private Button insent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

//受到隔夜惹桃花都是废话对方过后发过火电饭锅电饭锅

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        sex = (EditText) findViewById(R.id.sex);
        insent = (Button) findViewById(R.id.insent);

        insent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insent:
                PeopleDao peopleDao = App.getApplication().getDaoSession().getPeopleDao();
                People people=new People();
                people.setName(name.getText().toString());
                people.setAge(age.getText().toString());
                people.setSex(sex.getText().toString());
                peopleDao.insert(people);
                finish();
                break;
        }
    }
}
