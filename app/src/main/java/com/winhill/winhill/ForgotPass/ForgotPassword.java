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


public class ForgotPassword extends Fragment implements View.OnClickListener {

    View rootView;
    protected EditText email;
    Button continue_forgot_butt;
    Button forgotPassBack;
    FragmentTransaction fragManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.forgot_pass, container, false);

        continue_forgot_butt= (Button) rootView.findViewById(R.id.continue_forgot_butt);
        email =(EditText) rootView.findViewById(R.id.forgotEmailText);
        forgotPassBack = (Button) rootView.findViewById(R.id.forgotBackButt);


        continue_forgot_butt.setOnClickListener(this);
        forgotPassBack.setOnClickListener(this);


        return rootView;
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.continue_forgot_butt:

                final String getEmail = email.getText().toString();

                ValidatorLogIn logIn = new ValidatorLogIn();


                if (logIn.isValidEmail(getEmail) == true) {


                    fragManager = getFragmentManager().beginTransaction()
                            .setCustomAnimations(R.animator.gla_there_come, R.animator.gla_there_gone);
                    fragManager.replace(R.id.container, new LoginFrame(), "LoginMenu");
                    fragManager.commit();
                } else {
                    email.setError("Invalid Email");
                }
                break;
            case R.id.forgotBackButt:
                getActivity().onBackPressed();
                break;
        }

    }
}
