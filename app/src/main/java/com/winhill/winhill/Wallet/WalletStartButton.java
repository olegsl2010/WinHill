package com.winhill.winhill.Wallet;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.FundSource.FundingSourceList;
import com.winhill.winhill.Logining.LoginFrame;
import com.winhill.winhill.R;
import com.winhill.winhill.Refill.RefillMenu;
import com.winhill.winhill.Settings.SettingMain;
import com.winhill.winhill.Transfers.TransferMain;
import com.winhill.winhill.WHaccount.WalletListMenu;
import com.winhill.winhill.Withdraw.WithdrawMenu;

/**
 * Created by olegs_000 on 28.07.2015.
 */
public class WalletStartButton extends Fragment implements View.OnClickListener {

    View rootView;

    Button wallet;
    Button transfer;
    Button settings;

    FragmentTransaction FragManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.wallet_under_menu, container, false);


        wallet = (Button) rootView.findViewById(R.id.wallet);
        transfer = (Button) rootView.findViewById(R.id.transfer);
        settings = (Button) rootView.findViewById(R.id.settings);


        wallet.setOnClickListener(this);
        transfer.setOnClickListener(this);
        settings.setOnClickListener(this);

        FragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        FragManager.addToBackStack("");
        FragManager.add(R.id.dinamicFragment, new WalletMain(),"WHaccount");
        FragManager.commit();



        return rootView;
    }

    @Override
    public void onClick(View v) {
        FragManager = null;
        int buttonIndex = translateIdToIndex(v.getId());

        switch (buttonIndex) {

            case (1):
                wallet.setBackgroundResource(R.drawable.wallet_on);
                transfer.setBackgroundResource(R.drawable.transfer_off);
                settings.setBackgroundResource(R.drawable.settings_off);
                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                FragManager.replace(R.id.dinamicFragment, new WalletMain(), "WHaccount");
                FragManager.commit();

                break;
            case (2):
                wallet.setBackgroundResource(R.drawable.wallet_off);
                transfer.setBackgroundResource(R.drawable.transfer_on);
                settings.setBackgroundResource(R.drawable.settings_off);
                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                FragManager.replace(R.id.dinamicFragment, new TransferMain(), "TransferMain");
                FragManager.commit();

                break;
            case (3):
                wallet.setBackgroundResource(R.drawable.wallet_off);
                transfer.setBackgroundResource(R.drawable.transfer_off);
                settings.setBackgroundResource(R.drawable.settings_on);

                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                FragManager.replace(R.id.listMenu, new SettingMain(), "SettingsMain");
                FragManager.commit();
                break;
        }
    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {

            case R.id.wallet:
                index = 1;
                break;
            case R.id.transfer:
                index = 2;
                break;
            case R.id.settings:
                index = 3;
                break;
        }
        return index;
    }
}
