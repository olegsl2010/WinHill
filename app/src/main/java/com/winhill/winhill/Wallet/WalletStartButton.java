package com.winhill.winhill.Wallet;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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
    String TAG = "WalletStartButton";
    Button wallet;
    Button transfer;
    Button settings;

    FragmentTransaction fragManager;


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

        fragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        fragManager.replace(R.id.dinamicFragment, new WalletMain(), "WHaccount");
        fragManager.commit();
        Log.d(TAG,"Oncreate");


        return rootView;
    }

    @Override
    public void onClick(View v) {
        fragManager = getFragmentManager().beginTransaction();

        switch (v.getId()) {

            case R.id.wallet:

                if (getFragmentManager().findFragmentByTag("WHaccount") == null) {
                    wallet.setBackgroundResource(R.drawable.wallet_on);
                    transfer.setBackgroundResource(R.drawable.transfer_off);
                    settings.setBackgroundResource(R.drawable.settings_off);

                    fragManager.setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    fragManager.replace(R.id.dinamicFragment, new WalletMain(), "WHaccount");
                    Log.d(TAG,"Case 1 = null");}


                break;
            case R.id.transfer:
                if (getFragmentManager().findFragmentByTag("TransferMain") == null) {
                    wallet.setBackgroundResource(R.drawable.wallet_off);
                    transfer.setBackgroundResource(R.drawable.transfer_on);
                    settings.setBackgroundResource(R.drawable.settings_off);

                    fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                    fragManager.replace(R.id.dinamicFragment, new TransferMain(), "TransferMain");
                    Log.d(TAG,"Case 2 = null");}


                break;
            case R.id.settings:
                if (getFragmentManager().findFragmentByTag("SettingsMain") == null) {
                    wallet.setBackgroundResource(R.drawable.wallet_off);
                    transfer.setBackgroundResource(R.drawable.transfer_off);
                    settings.setBackgroundResource(R.drawable.settings_on);


                    fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                    fragManager.replace(R.id.dinamicFragment, new SettingMain(), "SettingsMain");
                    Log.d(TAG,"Case 3 = null");}
                break;

        }
        fragManager.commit();
    }


    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    if (getFragmentManager().findFragmentByTag("WHaccount") == null ) {

                        wallet.setBackgroundResource(R.drawable.wallet_on);
                        transfer.setBackgroundResource(R.drawable.transfer_off);
                        settings.setBackgroundResource(R.drawable.settings_off);
                        fragManager = getFragmentManager().beginTransaction()
                                .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                        fragManager.replace(R.id.dinamicFragment, new WalletMain(), "WHaccount");
                        fragManager.commit();
                        Log.d(TAG,"onBack = null");}


                    return true;
                }
                return false;
            }
        });
    }
}
