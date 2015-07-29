package com.winhill.winhill.SignUp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.DemoMode.DemoMode;
import com.winhill.winhill.ForgotPass.ForgotPassword;
import com.winhill.winhill.Logining.LogIn;
import com.winhill.winhill.R;

/**
 * Created by olegs_000 on 21.07.2015.
 */
public class SignUp extends Fragment implements View.OnClickListener {

    FragmentTransaction FragManager;
    View rootView;
    Button via_mail;
    Button via_facebook;
    Button via_linkedin;
    Button via_google;





    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.sign_up_first, container, false);

        via_mail = (Button) rootView.findViewById(R.id.via_mail);
        via_facebook= (Button) rootView.findViewById(R.id.via_facebook);
        via_linkedin = (Button) rootView.findViewById(R.id.via_linkedin);
        via_google = (Button) rootView.findViewById(R.id.via_google);

        via_mail.setOnClickListener(this);
        via_facebook.setOnClickListener(this);
        via_linkedin.setOnClickListener(this);
        via_google.setOnClickListener(this);

        return rootView;}

    @Override
    public void onClick(View v) {
        FragManager=null;
        int buttonIndex = translateIdToIndex(v.getId());
        switch (buttonIndex) {
            case (1):
                FragManager = getFragmentManager().beginTransaction();
                FragManager.addToBackStack("");
                FragManager.replace(R.id.container, new SignUpMail());
                FragManager.commit();
                break;
            case (2):
                getActivity().onBackPressed();
                break;
            case (3):
                getActivity().onBackPressed();
                break;
            case (4):
                getActivity().onBackPressed();
                break;
        }
    }

    int translateIdToIndex(int id) {
        int index = -1;
        switch (id) {
            case R.id.via_mail:
                index = 1;
                break;
            case R.id.via_facebook:
                index = 2;
                break;
            case R.id.via_linkedin:
                index = 3;
                break;
            case R.id.via_google:
                index = 4;
                break;
        }
        return index;
    }
}
