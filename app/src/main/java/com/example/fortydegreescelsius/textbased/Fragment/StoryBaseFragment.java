package com.example.fortydegreescelsius.textbased.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fortydegreescelsius.textbased.Model.Question;
import com.example.fortydegreescelsius.textbased.R;
import com.example.fortydegreescelsius.textbased.SqlDB.DBHelper;

import java.util.List;

/**
 * Created by FORTYDEGREESCELSIUS on 1/24/2017.
 */
public class StoryBaseFragment extends Fragment {

    TextView tvQuestion, tvChapter;
    public static SharedPreferences sharedPref;
    public static Context con;
    public static Activity act;

    @Override
    public void onStart() {
        super.onStart();
        con = this.getContext();
        act = this.getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.story_base_fragment, container, false);

        tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
        tvChapter = (TextView) view.findViewById(R.id.tvChapter);

        DBHelper db = new DBHelper(getContext());


//        List<Question> question = db.getQuest(2);
//        System.out.println(question);
//        for (Question cn : question) {
//            System.out.println("Id: " + cn.getID() + " ,Scene: " + cn.getScene() + " ,Question: " + cn.getQuestion() + " ,Chapter: " + cn.getChapter());
//            tvChapter.setText("Chapter: "+cn.getChapter());
//            tvQuestion.setText(cn.getQuestion());
//        }

        /* Chapter 1 */



        return view;
    }
}
