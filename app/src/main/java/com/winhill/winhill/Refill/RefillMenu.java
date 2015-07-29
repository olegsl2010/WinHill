package com.winhill.winhill.Refill;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.winhill.winhill.R;

/**
 * Created by olegs_000 on 23.07.2015.
 */
public class RefillMenu extends Fragment{

    View rootView;

    Spinner fromFindingRes;
    Spinner toWHAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.refill_menu, container, false);


        fromFindingRes = (Spinner) rootView.findViewById(R.id.fromFindingRes);
        toWHAccount =(Spinner) rootView.findViewById(R.id.toWHaccount);

        fromFindingRes.setPrompt("From finding resources");
        toWHAccount.setPrompt("To WH Account");


        return rootView;
    }
}
