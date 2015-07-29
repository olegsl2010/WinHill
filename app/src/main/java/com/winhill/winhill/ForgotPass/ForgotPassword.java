package com.winhill.winhill.ForgotPass;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.R;

/**
 * Created by olegs_000 on 21.07.2015.
 */
public class ForgotPassword extends Fragment  {

    View rootView;
    Button continue_forgot_butt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.forgot_pass, container, false);

continue_forgot_butt= (Button) rootView.findViewById(R.id.continue_forgot_butt);


        continue_forgot_butt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().onBackPressed();

            }});

        return rootView;
    }


}
