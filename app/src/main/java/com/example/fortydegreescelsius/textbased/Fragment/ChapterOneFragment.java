package com.example.fortydegreescelsius.textbased.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fortydegreescelsius.textbased.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by FORTYDEGREESCELSIUS on 1/25/2017.
 */
public class ChapterOneFragment extends StoryBaseFragment {

    TextView tvStory;
    Button btnNext,fBtn,sBtn;
    ListView lvContainer;
    ArrayList<String> arrConvo, arrReply;
    ArrayAdapter<String> adapterListLeft, adapterListReply;
    Integer event;
    View view;
    LinearLayout layoutButtons;
    LinearLayout.LayoutParams layoutParams;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.chapter_one_fragment, container, false);
        tvStory = (TextView) view.findViewById(R.id.tvStory);
        lvContainer = (ListView) view.findViewById(R.id.lvContainer);
        //btnNext = (Button) view.findViewById(R.id.btnNext);
        arrConvo = new ArrayList<String>();
        arrReply = new ArrayList<String>();
        adapterListLeft = new ArrayAdapter<String>(con, R.layout.scene_adapter, arrConvo);
        adapterListReply = new ArrayAdapter<String>(con, R.layout.reply_adapter, arrConvo);

        //btnNext.setOnClickListener(triggerEvent);

        getScenes(0);
        return view;
    }

    public void getScenes(int scene) {
        switch(scene) {
            case 0:
                    arrConvo.add("Hi! Unsa imo ngalan?");
                    lvContainer.setAdapter(adapterListLeft);
                    adapterListLeft.notifyDataSetChanged();

                    fBtn = new Button(con);
                    sBtn = new Button(con);
                    fBtn.setText("Isulti ako ngalan");
                    fBtn.setOnClickListener(convoEvents);
                    fBtn.setTag("first");

                    sBtn.setText("Ignore lang.");
                    sBtn.setOnClickListener(convoEvents);
                    sBtn.setTag("second");

                    layoutButtons = (LinearLayout) view.findViewById(R.id.chapOne);
                    layoutParams = new  LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(5, 3, 0, 0);
                    fBtn.setLayoutParams(layoutParams);
                    layoutButtons.addView(fBtn);
                    sBtn.setLayoutParams(layoutParams);
                    layoutButtons.addView(sBtn);

                break;
        }
    }

    View.OnClickListener convoEvents = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getTag().toString()) {
                case "first":
                    event = 1;
                    triggerEvent(event);
                    fBtn.setVisibility(View.GONE);
                    sBtn.setVisibility(View.GONE);
                    break;
                case "second":
                    event = 2;
                    triggerEvent(event);
                    fBtn.setVisibility(View.GONE);
                    sBtn.setVisibility(View.GONE);
                    break;
            }
        }
    };

    public void triggerEvent(Integer event) {
        switch (event) {
            case 1:
                arrConvo.add("Ako ngalan kay si churbabells eheheh");
                lvContainer.setAdapter(adapterListReply);
                adapterListReply.notifyDataSetChanged();
                event = 0;
                break;
            case 2:
                arrConvo.add("Wa kay batasan!");
                lvContainer.setAdapter(adapterListReply);
                adapterListReply.notifyDataSetChanged();
                event = 0;
                break;
        }
    }

//    View.OnClickListener triggerEvent = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (event) {
//                case 1:
//                        arrConvo.add("Ako ngalan kay si churbabells eheheh");
//                        lvContainer.setAdapter(adapterList);
//                        adapterList.notifyDataSetChanged();
//                        event = 0;
//                    break;
//                case 2:
//                        arrConvo.add("Wa kay batasan!");
//                        lvContainer.setAdapter(adapterList);
//                        adapterList.notifyDataSetChanged();
//                        event = 0;
//                    break;
//            }
//        }
//    };


}
