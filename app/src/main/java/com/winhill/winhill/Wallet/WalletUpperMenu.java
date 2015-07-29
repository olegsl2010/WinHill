package com.winhill.winhill.Wallet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.winhill.winhill.ListAdapter.InsertList;
import com.winhill.winhill.ListAdapter.PostData;
import com.winhill.winhill.ListAdapter.PostItemAdapter;
import com.winhill.winhill.R;


import java.util.ArrayList;

/**
 * Created by olegs_000 on 22.07.2015.
 */
public class WalletUpperMenu extends Fragment{
    View rootView;

    public static Fragment newInstance() {
        WalletUpperMenu mFrgment = new WalletUpperMenu();
        return mFrgment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wallet_upper_menu, container, false);




        return rootView;
    }
}
