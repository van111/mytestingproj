package com.example.fortydegreescelsius.textbased.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.fortydegreescelsius.textbased.Model.Question;
import com.example.fortydegreescelsius.textbased.R;
import com.example.fortydegreescelsius.textbased.SqlDB.DBHelper;

import java.util.ArrayList;

/**
 * Created by FORTYDEGREESCELSIUS on 12/16/2016.
 */
public class QuestionAddActivity extends QuestionBasedActivity {

    EditText etQuestion, etChapter, etScene;
    Button btnAdd;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_add);

        etQuestion = (EditText) this.findViewById(R.id.etQuestion);
        etChapter = (EditText) this.findViewById(R.id.etChatper);
        etScene = (EditText) this.findViewById(R.id.etScene);
        btnAdd = (Button) this.findViewById(R.id.btnSaveQuestion);

        btnAdd.setOnClickListener(clickListner);
    }

    private View.OnClickListener clickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSaveQuestion:

                    String strQuestion = String.valueOf(etQuestion.getText()),
                            strChapter = String.valueOf(etChapter.getText());

                    Log.d("Insert: ", "Inserting ..");
                    db.addQuestion(new Question("1", strQuestion, strChapter));

                    finish();
                    break;
            }
        }
    };


}
