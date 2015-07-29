package com.winhill.winhill.Wallet;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winhill.winhill.R;

/**
 * Created by olegs_000 on 22.07.2015.
 */
public class WalletUnderMenu extends Fragment {

    View rootView;

    public static Fragment newInstance() {
        WalletUnderMenu mFrgment = new WalletUnderMenu();
        return mFrgment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wallet_under_menu, container, false);



        return rootView;
    }
}
