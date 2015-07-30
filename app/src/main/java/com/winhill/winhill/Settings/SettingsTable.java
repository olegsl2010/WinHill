package com.winhill.winhill.Settings;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.R;

/**
 * Created by apple on 29.07.15.
 */
public class SettingsTable extends Fragment implements View.OnClickListener {

    View rootView;
    Button photo;
    FragmentTransaction FragManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.settings_main, container, false);

        photo= (Button) rootView.findViewById(R.id.addPhoto);

        photo.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        FragManager=null;
        int buttonIndex = translateIdToIndex(v.getId());

        switch (buttonIndex) {
            case (1):

                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                FragManager.addToBackStack("");
                FragManager.replace(R.id.settingsList, new SettingsAddPhoto(), "TransferSend");
                FragManager.commit();

                break;

        }

    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.addPhoto :
                index = 1;
                break;

        }
        return index;
    }
}