package com.winhill.winhill.Transfers;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.FundSource.FundingSourceList;
import com.winhill.winhill.Logining.LoginFrame;
import com.winhill.winhill.R;
import com.winhill.winhill.WHaccount.WalletListMenu;

/**
 * Created by olegs_000 on 24.07.2015.
 */
public class TransferMain extends Fragment implements View.OnClickListener {

    View rootView;
    Button send;
    Button request;
    Button logOut;
    FragmentTransaction FragManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.transfer_main, container, false);

        send =(Button) rootView.findViewById(R.id.sendButt);
        request = (Button) rootView.findViewById(R.id.requestButt);
        logOut = (Button) rootView.findViewById(R.id.logOut);

        send.setOnClickListener(this);
        request.setOnClickListener(this);
        logOut.setOnClickListener(this);


        send.setTextColor(Color.RED);
        FragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
        FragManager.add(R.id.transferList, new TransferSendMenu(),"TransferSendMenu");
        FragManager.commit();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        FragManager=null;
        int buttonIndex = translateIdToIndex(v.getId());

        switch (buttonIndex) {
            case (1):

                Log.d("Send", String.valueOf(getFragmentManager().findFragmentById(R.id.transferSendText)));
                if(getActivity().findViewById(R.id.transferSendText)==null) {

                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    FragManager.addToBackStack("");
                    FragManager.replace(R.id.transferList, new TransferSendMenu(), "TransferSend");
                    FragManager.commit();
                    Log.d("Send", String.valueOf(getFragmentManager().findFragmentById(R.id.transferSendText)));
                    request.setTextColor(Color.BLACK);
                    send.setTextColor(Color.RED);
                }

                break;
            case (2):
                if(getActivity().findViewById(R.id.transferRequestText)==null) {
                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                    FragManager.addToBackStack("");
                    FragManager.replace(R.id.transferList, new TransferRequestMenu(), "TransferRequest");
                    FragManager.commit();
                    request.setTextColor(Color.RED);
                    send.setTextColor(Color.BLACK);
                }
                break;
            case (3):

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
            case R.id.sendButt :
                index = 1;
                break;
            case R.id.requestButt:
                index = 2;
                break;
            case R.id.logOut :
            index = 3;
            break;

        }
        return index;
    }
}