package com.example.fortydegreescelsius.textbased;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.fortydegreescelsius.textbased.Activity.QuestionActivity;
import com.example.fortydegreescelsius.textbased.Activity.QuestionBasedActivity;
import com.example.fortydegreescelsius.textbased.Activity.StoryBasedActivity;
import com.example.fortydegreescelsius.textbased.Model.Question;
import com.example.fortydegreescelsius.textbased.SqlDB.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnShowDB, btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDB = (Button) this.findViewById(R.id.btnShowDB);
        btnStart = (Button) this.findViewById(R.id.btnStart);

        btnShowDB.setOnClickListener(clickHandler);
        btnStart.setOnClickListener(clickHandler);

    }

    View.OnClickListener clickHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch(v.getId()) {
                case R.id.btnShowDB:
                    intent = new Intent(getApplicationContext(), QuestionBasedActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnStart:
                    intent = new Intent(getApplicationContext(), StoryBasedActivity.class);
                    startActivity(intent);
                    break;
                default:
            }
        }
    };

}
