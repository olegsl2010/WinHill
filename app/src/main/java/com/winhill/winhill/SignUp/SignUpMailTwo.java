package com.winhill.winhill.SignUp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.ForgotPass.ForgotPassword;
import com.winhill.winhill.R;
import com.winhill.winhill.Wallet.WalletMain;

/**
 * Created by olegs_000 on 21.07.2015.
 */
public class SignUpMailTwo extends Fragment {
    View rootView;
    Button agree_signup;
    FragmentTransaction FragManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sign_up_two, container, false);
        agree_signup = (Button) rootView.findViewById(R.id.agree_signup);

        agree_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragManager = getFragmentManager().beginTransaction();
                FragManager.addToBackStack("");
                FragManager.replace(R.id.container, new WalletMain());
                FragManager.commit();

            }});


        return rootView;}


}
