package br.com.mainpc.bdclassposgradsqlite.helpers;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by javab0y on 15/10/17.
 */

public class Database {
    private SQLiteDatabase sqld;
    private BDSQLiteHelper databaseHelper;

    public Database(BDSQLiteHelper manager) {
        this.databaseHelper = manager;
    }

    public void open() {
        if (databaseHelper != null) {
            sqld = databaseHelper.getWritableDatabase();
        }
    }

    public SQLiteDatabase get() {
        if (sqld != null && sqld.isOpen()) {
            return sqld;
        }
        return null;
    }

    public void close() {
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }
}
