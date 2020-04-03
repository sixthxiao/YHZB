package com.yahu.live.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static final String DB_NAME = "yhzb.db";
    private static final String DB_TABLE = "Historys";
    private static final int DB_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_TYPE = "type";
    public static final String KEY_NAME = "title";
    private SQLiteDatabase db;
    private final Context context;
    private DBOpenHelper dbOpenHelper;

    public DBManager(Context _context) {
        context = _context;
    }

    /**
     * 关闭数据库
     */
    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    /**
     * 打开数据库
     *
     * @throws SQLiteException
     */
    public void open() throws SQLiteException {
        dbOpenHelper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);
        try {
            db = dbOpenHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = dbOpenHelper.getReadableDatabase();
        }
    }

    public long insert(Historys gamers) {
        List<Historys> historyses = queryData(gamers.name);
        if (historyses != null && historyses.size() > 0) {
            if (gamers.type.equals(historyses.get(0).type)) {
                deleteOneData(historyses.get(0).ID);
            }
        }
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_NAME, gamers.name);
        newValues.put(KEY_TYPE, gamers.type);
        return db.insert(DB_TABLE, null, newValues);
    }

    public List<Historys> queryAllData() {
        Cursor results = db.query(DB_TABLE, null, null, null, null, null,
                KEY_ID + " desc");
        return ConvertToPeople(results);
    }

    public List<Historys> queryData(String name) {
        String[] columns = new String[]{};
        String selection = KEY_NAME + "=?";
        String[] selectionArgs = new String[]{name};
        Cursor results = db.query(DB_TABLE, null, selection, selectionArgs, null, null,
                null);
        return ConvertToPeople(results);
    }

    public List<Historys> queryDataByType(String type) {
        String[] columns = new String[]{};
        String selection = KEY_TYPE + "=?";
        String[] selectionArgs = new String[]{type};
        Cursor results = db.query(DB_TABLE, null, selection, selectionArgs, null, null,
                KEY_ID + " desc");
        return ConvertToPeople(results);
    }

    private List<Historys> ConvertToPeople(Cursor cursor) {
        List<Historys> products = new ArrayList<Historys>();
        Historys gamers;
        int resultCounts = cursor.getCount();
        if (resultCounts == 0 || !cursor.moveToFirst()) {
            return null;
        }
        for (int i = 0; i < resultCounts; i++) {
            gamers = new Historys();
            gamers.ID = cursor.getInt(0);
            gamers.name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
            gamers.type = cursor.getString(cursor.getColumnIndex(KEY_TYPE));
            products.add(gamers);
            cursor.moveToNext();
        }
        return products;
    }

    /**
     * 删除所有
     *
     * @return
     */
    public long deleteAllData() {
        return db.delete(DB_TABLE, null, null);
    }

    /**
     * 删除一条
     *
     * @param id
     * @return
     */
    public long deleteOneData(long id) {

        return db.delete(DB_TABLE, KEY_ID + "=" + id, null);
    }

    /**
     * 删除一条
     *
     * @return
     */
    public long deleteOne(String name) {

        return db.delete(DB_TABLE, KEY_NAME + "=" + name, null);
    }


    public long updateOneData(long id, Historys gamers) {
        ContentValues updateValues = new ContentValues();
        updateValues.put(KEY_NAME, gamers.name);
        updateValues.put(KEY_TYPE, gamers.type);
        return db.update(DB_TABLE, updateValues, KEY_ID + "=" + id, null);
    }

    /**
     * 静态Helper类，用于建立、更新和打开数据库
     */
    private static class DBOpenHelper extends SQLiteOpenHelper {
        public DBOpenHelper(Context context, String name,
                            CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        private static final String DB_CREATE = "create table " + DB_TABLE
                + " (" + KEY_ID + " integer primary key autoincrement, "
                + KEY_TYPE + " text not null," + KEY_NAME + " text not null"
                + ");";

        @Override
        public void onCreate(SQLiteDatabase _db) {
            Log.d("ook", "here_5");
            _db.execSQL(DB_CREATE);
            Log.d("ook", "here_6");
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int _oldVersion,
                              int _newVersion) {
            Log.d("ook", "here_7");
            _db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(_db);
            Log.d("ook", "here_8");
        }
    }
}
