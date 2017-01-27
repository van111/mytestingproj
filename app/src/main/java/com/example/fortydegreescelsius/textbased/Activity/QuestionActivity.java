package com.example.fortydegreescelsius.textbased.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fortydegreescelsius.textbased.MainActivity;
import com.example.fortydegreescelsius.textbased.Model.Question;
import com.example.fortydegreescelsius.textbased.R;
import com.example.fortydegreescelsius.textbased.SqlDB.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FORTYDEGREESCELSIUS on 12/5/2016.
 */
public class QuestionActivity extends MainActivity{

    ArrayList<String> aList;
    ArrayAdapter<String> adapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);

        DBHelper db = new DBHelper(this);

        ListView lv = (ListView) this.findViewById(R.id.listQID);

        aList = new ArrayList<String>();

        adapterList = new ArrayAdapter<String>(this, R.layout.question_adapter, aList);

//        Log.d("Insert: ", "Inserting ..");
//        db.addQuestion(new Question("1", "What is your name?", "Chapter 1"));
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Question> questions = db.getAllQuestions();
        System.out.println(questions);
        for (Question cn : questions) {
            aList.add("Id: "+cn.getID()+" ,Scene: " + cn.getScene() + " ,Question: " + cn.getQuestion() +" ,Chapter: " + cn.getChapter());
        }

        lv.setAdapter(adapterList);
        adapterList.notifyDataSetChanged();

    }
}
