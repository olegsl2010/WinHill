package com.winhill.winhill.Wallet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.winhill.winhill.FundSource.FundingSourceList;
import com.winhill.winhill.Logining.LoginFrame;
import com.winhill.winhill.R;
import com.winhill.winhill.Refill.RefillMenu;
import com.winhill.winhill.Settings.SettingMain;
import com.winhill.winhill.Transfers.TransferMain;
import com.winhill.winhill.Transfers.TransferSendMenu;
import com.winhill.winhill.WHaccount.WalletListMenu;
import com.winhill.winhill.Withdraw.WithdrawMenu;

/**
 * Created by olegs_000 on 21.07.2015.
 */
public class WalletMain extends Fragment implements View.OnClickListener{
    View rootView;
    String TAG = "WalletMain";
    Button whAccount;
    Button fundingSource;
    Button refill;
    Button withdraw;
    Button logOut;
    FragmentTransaction fragManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.wallet_start, container, false);

        whAccount = (Button) rootView.findViewById(R.id.wh_acc_wallet);
        fundingSource = (Button) rootView.findViewById(R.id.funding_source);
        refill = (Button) rootView.findViewById(R.id.refill);
        withdraw = (Button) rootView.findViewById(R.id.withdraw);
        logOut = (Button) rootView.findViewById(R.id.logOut);

        whAccount.setOnClickListener(this);
        fundingSource.setOnClickListener(this);
        refill.setOnClickListener(this);
        withdraw.setOnClickListener(this);
        logOut.setOnClickListener(this);

        fragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        fragManager.replace(R.id.listMenu, new WalletListMenu(),"ListWH");
        fragManager.commit();
        Log.d(TAG, "onCreate");
        return rootView;}



    @Override
    public void onClick(View v) {
        fragManager = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.wh_acc_wallet:
                if (getFragmentManager().findFragmentByTag("ListWH")== null) {

                    fragManager.setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    fragManager.replace(R.id.listMenu, new WalletListMenu(), "ListWH");
                    Log.d(TAG, "Case 1 = null");
                }

                break;
            case R.id.funding_source:
                if (getFragmentManager().findFragmentByTag("SourceList")== null) {
                    fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                fragManager.replace(R.id.listMenu, new FundingSourceList(), "SourceList");
                    Log.d(TAG, "Case 2 = null");
                }

                break;
            case R.id.refill:
                if (getFragmentManager().findFragmentByTag("RefillMenu")== null){
                    fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                fragManager.replace(R.id.listMenu, new RefillMenu(), "RefillMenu");
                    Log.d(TAG, "Case 3 = null");
                }

                break;

            case R.id.withdraw:
                if (getFragmentManager().findFragmentByTag("withdrawMenu")== null){
                    fragManager.setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                fragManager.replace(R.id.listMenu, new WithdrawMenu(), "withdrawMenu");
                }

                break;
            case R.id.logOut:

                fragManager.setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    fragManager.replace(R.id.container, new LoginFrame(),"LoginMenu");

                break;
        }
        fragManager.commit();
    }
}
