package com.example.fortydegreescelsius.textbased.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fortydegreescelsius.textbased.MainActivity;
import com.example.fortydegreescelsius.textbased.R;

/**
 * Created by FORTYDEGREESCELSIUS on 12/8/2016.
 */
public class QuestionBasedActivity extends MainActivity{

    Button btnDisplayData, btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_base_activity);

        btnDisplayData = (Button) this.findViewById(R.id.btnDisplayData);
        btnAddData = (Button) this.findViewById(R.id.btnAddData);

        btnDisplayData.setOnClickListener(clickHandler);
        btnAddData.setOnClickListener(clickHandler);
    }

    View.OnClickListener clickHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;

            switch(v.getId()) {
                case R.id.btnDisplayData:
                    intent = new Intent(getApplicationContext(), QuestionActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnAddData:
                    Log.d("[Debug]:", "here");
                    intent = new Intent(getApplicationContext(), QuestionAddActivity.class);
                    startActivity(intent);
                    break;
                default:
            }
        }
    };
}
