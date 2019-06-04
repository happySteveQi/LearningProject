package com.example.learning.model.db;

import com.example.learning.model.bean.ReadStateBean;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmHelper implements DBHelper {

    private static final String DB_NAME = "greek_realm";

    private Realm mRealm;

    @Inject
    public RealmHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build()
        );
    }

    @Override
    public void insertNewsId(int id) {
        ReadStateBean bean = new ReadStateBean();
        bean.setId(id);
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(bean);
        mRealm.commitTransaction();
    }

    @Override
    public boolean queryNewsId(int id) {
        RealmResults<ReadStateBean> results = mRealm.where(ReadStateBean.class).findAll();
        for (ReadStateBean item: results) {
            if(item.getId() == id){
                return true;
            }
        }
        return false;
    }
}
