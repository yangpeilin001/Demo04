package com.example.acer.demo04;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.acer.demo04.gen.DaoMaster;
import com.example.acer.demo04.gen.DaoSession;

/**
 * Created by ACER on 2018/2/25.
 */

public class App extends Application {

    private static App application;
    private DaoSession daoSession;

    public static App getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        creatDB();
    }

    private void creatDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "greendao.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
