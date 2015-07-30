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
    FragmentTransaction fragManager;


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
        fragManager = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.addPhoto:

                fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                fragManager.addToBackStack("");
                fragManager.replace(R.id.settingsList, new SettingsAddPhoto(), "TransferSend");

                break;
        }
        fragManager.commit();

    }
}
