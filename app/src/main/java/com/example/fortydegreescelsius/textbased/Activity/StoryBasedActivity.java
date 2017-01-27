package com.example.fortydegreescelsius.textbased.Activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.fortydegreescelsius.textbased.Fragment.CharacterCreationFragment;
import com.example.fortydegreescelsius.textbased.Fragment.StoryBaseFragment;
import com.example.fortydegreescelsius.textbased.MainActivity;
import com.example.fortydegreescelsius.textbased.Model.Question;
import com.example.fortydegreescelsius.textbased.R;
import com.example.fortydegreescelsius.textbased.SqlDB.DBHelper;

import java.util.List;

/**
 * Created by FORTYDEGREESCELSIUS on 1/17/2017.
 */
public class StoryBasedActivity extends MainActivity {

    DBHelper db = new DBHelper(this);
    public StoryBaseFragment sbFragment;
    Button btnNewGame, btnSelectChapter;
    FrameLayout flMenu;
    public View sbContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_base_activity);

        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnSelectChapter = (Button) findViewById(R.id.btnSelectChapter);

        btnNewGame.setOnClickListener(startAction);
        btnSelectChapter.setOnClickListener(startAction);

        flMenu = (FrameLayout) findViewById(R.id.flMenu);

        sbContainer = findViewById(R.id.container);
    }

    //TODO pick chapter or get username
    View.OnClickListener startAction = new View.OnClickListener() {
        StoryBaseFragment f;
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnNewGame:
                    f = new CharacterCreationFragment();
                    flMenu.setVisibility(View.GONE);
                    break;
                case R.id.btnSelectChapter:
                    break;
            }

            //sbContainer.setLayoutParams(params);
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, f);
            ft.commitAllowingStateLoss();

            sbFragment = f;
        }
    };

}
