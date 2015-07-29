package com.winhill.winhill.Logining;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.DemoMode.DemoMode;
import com.winhill.winhill.ForgotPass.ForgotPassword;
import com.winhill.winhill.R;
import com.winhill.winhill.SignUp.SignUp;
import com.winhill.winhill.Wallet.WalletMain;
import com.winhill.winhill.Wallet.WalletStartButton;

/**
 * Created by olegs_000 on 21.07.2015.
 */
public class LoginFrame extends Fragment implements View.OnClickListener {

    View rootView;
    Button forgot_pass_butt;
    Button sign_up_butt;
    Button lunch_demo_butt;
    Button log_in_butt;
    FragmentTransaction FragManager;





    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.login_frame, container, false);

        forgot_pass_butt = (Button) rootView.findViewById(R.id.forgot_pass_butt);
        sign_up_butt = (Button) rootView.findViewById(R.id.sign_up_butt);
        lunch_demo_butt = (Button) rootView.findViewById(R.id.lunch_demo_butt);
        log_in_butt = (Button) rootView.findViewById(R.id.log_in_butt);

        forgot_pass_butt.setOnClickListener(this);
        sign_up_butt.setOnClickListener(this);
        lunch_demo_butt.setOnClickListener(this);
        log_in_butt.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        FragManager=null;
        int buttonIndex = translateIdToIndex(v.getId());
        switch (buttonIndex) {
            case (1):
                FragManager = getFragmentManager().beginTransaction();
                FragManager.replace(R.id.container, new ForgotPassword());
                FragManager.commit();
                break;
            case (2):
                FragManager = getFragmentManager().beginTransaction();
                FragManager.replace(R.id.container, new SignUp());
                FragManager.commit();
                break;
            case (3):
                FragManager = getFragmentManager().beginTransaction();
                FragManager.addToBackStack("");
                FragManager.replace(R.id.container, new WalletStartButton()); // не тооо
                FragManager.commit();
                break;
            case (4):
                if(getFragmentManager().findFragmentByTag("WalletMain")!=null){

                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                    FragManager.replace(R.id.container, new WalletStartButton(),"WalletMain");
                    FragManager.addToBackStack("");
                    FragManager.commit();

                }else{

                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                    FragManager.replace(R.id.container, new WalletStartButton(),"WalletMain");
                    FragManager.addToBackStack("");
                    FragManager.commit();}
                break;
        }
    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.forgot_pass_butt:
                index = 1;
                break;
            case R.id.sign_up_butt:
                index = 2;
                break;
            case R.id.lunch_demo_butt:
                index = 3;
                break;
            case R.id.log_in_butt:
                index = 4;
                break;
        }
        return index;
    }
}
