package com.liqy.androd1510c;

import android.app.Application;

import com.liqy.androd1510c.model.DaoMaster;
import com.liqy.androd1510c.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by liqy on 2018/1/5.
 */

public class App extends Application{

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"test.db");
        Database database=helper.getWritableDb();
        daoSession=new DaoMaster(database).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
