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
    Button whAccount;
    Button fundingSource;
    Button refill;
    Button withdraw;
    Button logOut;
    FragmentTransaction FragManager;



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

        FragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        FragManager.replace(R.id.listMenu, new WalletListMenu());
        FragManager.commit();
        return rootView;}



    @Override
    public void onClick(View v) {
        FragManager=null;
        int buttonIndex = translateIdToIndex(v.getId());

        switch (buttonIndex) {
            case (1):

                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                FragManager.replace(R.id.listMenu, new WalletListMenu(), "WHaccount");
                FragManager.commit();

                break;
            case (2):

                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                FragManager.replace(R.id.listMenu, new FundingSourceList(),"SourceList");
                FragManager.commit();

                break;
            case (3):

                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                FragManager.addToBackStack("");
                FragManager.replace(R.id.listMenu, new RefillMenu(),"RefillMenu");
                FragManager.commit();
                break;

            case (4):

                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                FragManager.replace(R.id.listMenu, new WithdrawMenu(),"withdrawMenu");
                FragManager.commit();
                break;
            case (5):

                if(getFragmentManager().findFragmentByTag("LoginMenu")!=null){

//                    FragManager = getFragmentManager().beginTransaction();
////                    FragManager.remove(getFragmentManager().findFragmentById(R.id.upperMenu));
//                    FragManager.remove(getFragmentManager().findFragmentById(R.id.underMenu));
//                    FragManager.commit();
                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                    FragManager.replace(R.id.container, new LoginFrame(),"LoginMenu");
                    FragManager.commit();
                }else{

                FragManager = getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come);
                FragManager.replace(R.id.container, new LoginFrame(),"LoginMenu");
                FragManager.addToBackStack("");
                FragManager.commit();}

                break;
        }
    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.wh_acc_wallet :
                index = 1;
                break;
            case R.id.funding_source:
                index = 2;
                break;
            case R.id.refill:
                index = 3;
                break;
            case R.id.withdraw:
                index = 4;
                break;
            case R.id.logOut:
                index = 5;
                Log.d("dsdsdsd", String.valueOf(index));
                break;
        }
        return index;
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

                    FragManager = getFragmentManager().beginTransaction();
                    FragManager.replace(R.id.listMenu, new WalletListMenu(),"WHaccount");
                    FragManager.commit();

                    return true;
                }
                return false;
            }
        });
    }

}
