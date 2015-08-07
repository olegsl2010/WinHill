package com.winhill.winhill.WHaccount;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winhill.winhill.R;

/**
 * Created by apple on 30.07.15.
 */
public class ItemList extends Fragment {
    View rootView;
    String titleName;
    TextView  textTitle;

    public void setTextForView(String title){
        titleName = title;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.item_list_view, container, false);

        textTitle = (TextView) rootView.findViewById(R.id.itemText);
        textTitle.setText(titleName);


        return rootView;
    }


}
