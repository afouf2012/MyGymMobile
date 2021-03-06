package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyExercicesDB extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Exercice.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_exercices";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "exercice_title";
    private static final String COLUMN_CATEGORY = "exercice_category";
    private static final String COLUMN_DURATION = "exercice_duration";


    private static final String TABLE_NAME2 = "my_program";
    private static final String COLUMN_ID2 = "_id";
    private static final String COLUMN_DESCRIPTION = "program_description";
    private static final String COLUMN_CATEGORY2 = "program_category";
    private static final String COLUMN_IMAGE = "program_image";




    MyExercicesDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_CATEGORY + " TEXT, " +
                        COLUMN_DURATION + " INTEGER);";

        String query2 = "CREATE TABLE " + TABLE_NAME2 +
                " (" + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_CATEGORY2 + " TEXT, " +
                COLUMN_IMAGE + " INTEGER);";

        db.execSQL(query);
        db.execSQL(query2);




    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    void addBook(String title, String author, int pages){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_CATEGORY, author);
        cv.put(COLUMN_DURATION, pages);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void addExercices(String description, String category, int images)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_CATEGORY2, category);
        cv.put(COLUMN_IMAGE, images);

        long result = db.insert(TABLE_NAME2,null, cv);

        }


    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }



    Cursor readAllData2(){
        String query = "SELECT * FROM " + TABLE_NAME2;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor SearchData(String categorie){
        String query = "SELECT * FROM " + TABLE_NAME2 + " WHERE "  + COLUMN_CATEGORY2 +  categorie ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("SELECT * FROM my_program WHERE TRIM(program_category) = '"+categorie.trim()+"'", null);
           // cursor = db.rawQuery(query, null);
        }
        return cursor;
    }



    void updateData(String row_id, String title, String category, String duration){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_CATEGORY, category);
        cv.put(COLUMN_DURATION, duration);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
