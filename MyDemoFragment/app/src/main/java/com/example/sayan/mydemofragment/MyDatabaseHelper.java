package com.example.sayan.mydemofragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tasks.db";
    private static final String TABLE_TASKS = "tasks";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TASKNAME = "taskname";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_TASKS + "("  + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
        + COLUMN_TASKNAME  + " TEXT " + ");";
        db.execSQL(query);

    }

    public void addTask(Tasks tasks){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TASKNAME,tasks.get_taskname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TASKS,null,values);
        db.close();
    }

    public void removeTasks(String taskname){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(" DELETE FROM " + TABLE_TASKS + " WHERE " + COLUMN_TASKNAME + "=\"" + taskname + "\";");
    }

    public String databasetostring(){
        String dbstring = "";

        SQLiteDatabase db = getWritableDatabase();

        String query = " SELECT * FROM " + TABLE_TASKS + " WHERE 1 ";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("taskname"))!=null){
                dbstring += c.getString(c.getColumnIndex("taskname"));
                dbstring += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbstring;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_TASKS);

        onCreate(db);
    }
}
