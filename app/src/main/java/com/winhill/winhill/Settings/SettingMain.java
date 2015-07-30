package com.winhill.winhill.Settings;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.Logining.LoginFrame;
import com.winhill.winhill.R;
import com.winhill.winhill.Transfers.TransferRequestMenu;
import com.winhill.winhill.Transfers.TransferSendMenu;

/**
 * Created by olegs_000 on 24.07.2015.
 */
public class SettingMain extends Fragment implements View.OnClickListener {

    View rootView;
    FragmentTransaction FragManager;
    Button logOut;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.settings_start, container, false);


        logOut = (Button) rootView.findViewById(R.id.logOut);
        logOut.setOnClickListener(this);


        FragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        FragManager.addToBackStack("");
        FragManager.replace(R.id.settingsList, new SettingsTable(), "TransferSend");
        FragManager.commit();

        return rootView;
    }


    @Override
    public void onClick(View v) {
        FragManager = null;
        int buttonIndex = translateIdToIndex(v.getId());

        switch (buttonIndex) {
            case (1):

                if (getFragmentManager().findFragmentByTag("LoginMenu") != null) {

                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    FragManager.replace(R.id.container, new LoginFrame(), "LoginMenu");
                    FragManager.commit();
                } else {

                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    FragManager.replace(R.id.container, new LoginFrame(), "LoginMenu");
                    FragManager.addToBackStack("");
                    FragManager.commit();
                }

                break;

        }
    }
    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.logOut :
                index = 1;
                break;
        }
        return index;
    }
}
