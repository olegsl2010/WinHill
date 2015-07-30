package com.winhill.winhill.ForgotPass;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.winhill.winhill.Logining.LoginFrame;
import com.winhill.winhill.Logining.ValidatorLogIn;
import com.winhill.winhill.R;
import com.winhill.winhill.Wallet.WalletMain;
import com.winhill.winhill.Wallet.WalletStartButton;

/**
 * Created by olegs_000 on 21.07.2015.
 */
public class ForgotPassword extends Fragment  {

    View rootView;
    protected EditText email;
    Button continue_forgot_butt;
    FragmentTransaction FragManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.forgot_pass, container, false);

        continue_forgot_butt= (Button) rootView.findViewById(R.id.continue_forgot_butt);
        email =(EditText) rootView.findViewById(R.id.forgotEmailText);



        continue_forgot_butt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String getEmail = email.getText().toString();

                ValidatorLogIn logIn = new ValidatorLogIn();


                if (logIn.isValidEmail(getEmail) == true) {


                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
                    FragManager.replace(R.id.container, new LoginFrame(),"LoginMenu");
                    FragManager.commit();
                }else
                {
                    email.setError("Invalid Email");
                }

            }});



        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {


                    FragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                    FragManager.replace(R.id.container, new LoginFrame(),"LoginMenu");
                    FragManager.commit();

                    return true;
                }
                return false;
            }
        });
    }



}
