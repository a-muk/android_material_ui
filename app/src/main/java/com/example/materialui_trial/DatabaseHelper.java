package com.example.materialui_trial;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="ProjectDB";
    private static final String DATABASE_VERSION="1";
    public static final String TABLE_NAME="Comments";
    public static final String IP="ip";
    public static final String Comment="comment";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null, Integer.parseInt(DATABASE_VERSION));
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create TABLE " +TABLE_NAME + "(" +IP+ "text not null , " + Comment + " text not null); ");
        SQLiteDatabase database =this.getWritableDatabase();
        database.close();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);

    }
    public void addContent(String ip, String comment){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        db.insert(TABLE_NAME,null, values);

    }

}
