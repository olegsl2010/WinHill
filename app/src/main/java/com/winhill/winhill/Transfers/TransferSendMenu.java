package com.winhill.winhill.Transfers;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.winhill.winhill.R;

/**
 * Created by olegs_000 on 24.07.2015.
 */
public class TransferSendMenu extends Fragment{

    View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.transfer_send, container, false);


        return rootView;
    }
}
