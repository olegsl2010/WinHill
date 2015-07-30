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
        FragManager = getFragmentManager().beginTransaction();


        switch (v.getId()) {
            case R.id.sendButt:

                Log.d("Send", String.valueOf(getFragmentManager().findFragmentById(R.id.transferSendText)));
                if(getActivity().findViewById(R.id.transferSendText)==null) {

                    FragManager.setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    FragManager.replace(R.id.transferList, new TransferSendMenu(), "TransferSend");
                    request.setTextColor(Color.BLACK);
                    send.setTextColor(Color.RED);
                }
                break;
            case R.id.requestButt:
                if(getActivity().findViewById(R.id.transferRequestText)==null) {

                    FragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                    FragManager.replace(R.id.transferList, new TransferRequestMenu(), "TransferRequest");
                    request.setTextColor(Color.RED);
                    send.setTextColor(Color.BLACK);
                }
                break;
            case R.id.logOut:

                FragManager.setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                FragManager.replace(R.id.container, new LoginFrame(), "LoginMenu");
                break;
        }
        FragManager.commit();
    }

}