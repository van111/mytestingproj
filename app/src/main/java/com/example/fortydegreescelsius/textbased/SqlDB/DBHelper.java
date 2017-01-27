package com.example.fortydegreescelsius.textbased.SqlDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fortydegreescelsius.textbased.Model.Question;
import com.example.fortydegreescelsius.textbased.Model.User;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FORTYDEGREESCELSIUS on 11/30/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;

    private static final String DATABASE_NAME = "textBaseDB";

    //Table Name
    private static final String TABLE_QUESTIONS = "questions";
    private static final String TABLE_USERS = "users";

    //Table columns
    private static final String KEY_ID = "id";
    private static final String KEY_SCENE = "scene";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_CHAPTER = "chapter";
    private static final String KEY_USER = "username";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_QUESTIONS + "(" + KEY_ID + "  INTEGER PRIMARY KEY, " + KEY_SCENE + " TEXT, " + KEY_QUESTION + " TEXT, " + KEY_CHAPTER + " TEXT" + ")";
        db.execSQL(CREATE_QUESTIONS_TABLE);

        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "(" + KEY_ID + "  INTEGER PRIMARY KEY, " + KEY_SCENE + " TEXT, " + KEY_USER + " TEXT, " + KEY_CHAPTER + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    Question getQuestion(int id) {
        return null;
    }

    public List<Question> getQuest(int id) {
        List<Question> questionList = new ArrayList<Question>();

        String selectQuery = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE "+ KEY_ID +" = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setID(Integer.parseInt(cursor.getString(0)));
                question.setScene(cursor.getString(1));
                question.setQuestion(cursor.getString(2));
                question.setChapter(cursor.getString(3));
                // Adding question to list
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        return questionList;
    }

    // Getting All Contacts
    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setID(Integer.parseInt(cursor.getString(0)));
                question.setScene(cursor.getString(1));
                question.setQuestion(cursor.getString(2));
                question.setChapter(cursor.getString(3));
                // Adding question to list
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        // return contact list
        return questionList;
    }

    // Getting All Contacts
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setID(Integer.parseInt(cursor.getString(0)));
                user.setScene(cursor.getString(1));
                user.setUsername(cursor.getString(2));
                user.setChapter(cursor.getString(3));
                // Adding question to list
                userList.add(user);
            } while (cursor.moveToNext());
        }

        // return contact list
        return userList;
    }

    public void addQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        System.out.println("[ContentValues]: " + values);
        //values.put(KEY_ID, question.getID());
        values.put(KEY_SCENE, question.getScene());
        values.put(KEY_QUESTION, question.getQuestion());
        values.put(KEY_CHAPTER, question.getChapter());

        db.insert(TABLE_QUESTIONS, null, values);
        db.close();
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        System.out.println("[ContentValues]: " + values);
        values.put(KEY_SCENE, user.getScene());
        values.put(KEY_USER, user.getUsername());
        values.put(KEY_CHAPTER, user.getChapter());

        db.insert(TABLE_USERS, null, values);
        db.close();
    }
}
