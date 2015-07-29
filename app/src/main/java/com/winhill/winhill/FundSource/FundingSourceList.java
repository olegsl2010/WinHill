package com.winhill.winhill.FundSource;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.winhill.winhill.ListAdapter.InsertList;
import com.winhill.winhill.ListAdapter.PostData;
import com.winhill.winhill.ListAdapter.PostItemAdapter;
import com.winhill.winhill.R;

import java.util.ArrayList;

/**
 * Created by olegs_000 on 23.07.2015.
 */
public class FundingSourceList extends Fragment{

    View rootView;



    ListView ourListView;
    private ArrayList<PostData> listData;
    InsertList listWallet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wallet_list_menu, container, false);



        ourListView = (ListView) rootView.findViewById(R.id.listView);
        Log.d("ListMenu", ourListView.toString());
        listWallet = new InsertList();
        listData = new ArrayList<>();
        listData = listWallet.InsertList2();
        toList(listData);

        return rootView;
    }

    public void toList(ArrayList<PostData> listWallet) {
        PostItemAdapter itemAdapter = new PostItemAdapter(getActivity(), R.layout.postitem, listWallet);
        Log.d("To list wallet",String.valueOf(listWallet.size()));
        ourListView.setAdapter(itemAdapter);
    }
}
