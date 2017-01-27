package com.example.fortydegreescelsius.textbased.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.fortydegreescelsius.textbased.Model.User;
import com.example.fortydegreescelsius.textbased.R;
import com.example.fortydegreescelsius.textbased.SqlDB.DBHelper;

import java.util.List;

/**
 * Created by FORTYDEGREESCELSIUS on 1/25/2017.
 */
public class CharacterCreationFragment extends StoryBaseFragment{

    EditText etUsername;
    Button btnNext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.character_creation_fragment, container, false);

        etUsername = (EditText) view.findViewById(R.id.etUsername);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(nextAction);

        return view;
    }

    View.OnClickListener nextAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnNext:
                    System.out.println(con);
                    DBHelper db = new DBHelper(con);
                    String username = String.valueOf(etUsername.getText());
                    db.addUser(new User("", username, ""));

                    sharedPref = act.getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username", username);
                    editor.commit();

                    //TODO switch fragment to chapter one
                    switchFragment(new ChapterOneFragment());
                    break;
            }
        }
    };

    public void switchFragment(StoryBaseFragment f) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.container, f);
        ft.commit();
    }

}
