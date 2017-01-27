package com.example.fortydegreescelsius.textbased.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button btnNext;
    ListView lvContainer;
    ArrayList<String> arrConvo;
    ArrayAdapter<String> adapterList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chapter_one_fragment, container, false);
        tvStory = (TextView) view.findViewById(R.id.tvStory);
        lvContainer = (ListView) view.findViewById(R.id.lvContainer);

        getScenes(0);
        return view;
    }

    public void getScenes(int scene) {
        switch(scene) {
            case 0:
                    //tvStory.setText("Hi! Unsa imo ngalan?");
                    arrConvo = new ArrayList<String>();
                    adapterList = new ArrayAdapter<String>(con, R.layout.scene_adapter, arrConvo);
                    arrConvo.add("Hi! Unsa imo ngalan?");
                    lvContainer.setAdapter(adapterList);
                    adapterList.notifyDataSetChanged();
                break;
        }
    }
}
