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
    FragmentTransaction fragManager;
    Button logOut;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.settings_start, container, false);


        logOut = (Button) rootView.findViewById(R.id.logOut);
        logOut.setOnClickListener(this);


        fragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        fragManager.replace(R.id.settingsList, new SettingsTable(), "TransferSend");
        fragManager.commit();

        return rootView;
    }


    @Override
    public void onClick(View v) {
        fragManager = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.logOut:

                    fragManager.setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    fragManager.replace(R.id.container, new LoginFrame(), "LoginMenu");
                break;
        }
        fragManager.commit();
    }
}
