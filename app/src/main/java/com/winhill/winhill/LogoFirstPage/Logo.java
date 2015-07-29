package com.winhill.winhill.LogoFirstPage;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.winhill.winhill.Logining.LoginFrame;
import com.winhill.winhill.R;

/**
 * Created by olegs_000 on 21.07.2015.
 */
public class Logo extends Fragment implements View.OnClickListener {

    View rootView;
    Button logo;
    FragmentTransaction FragManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.logo_first_frame, container, false);

        logo = (Button) rootView.findViewById(R.id.logo);

        logo.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        FragManager = getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.gla_there_come,R.animator.gla_there_gone);
        FragManager.replace(R.id.container, new LoginFrame(),"LoginMenu");
        FragManager.commit();

    }

}
