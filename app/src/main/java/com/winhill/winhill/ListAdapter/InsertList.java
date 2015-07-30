package com.winhill.winhill.ListAdapter;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by olegs_000 on 22.07.2015.
 */
public class InsertList extends ArrayList<PostData> {

    private ArrayList<PostData> listData;
    PostData data;

    public ArrayList<PostData> InsertList(){
        listData = new ArrayList<>();
        data = new PostData();
        data.setPostDate("Available balance: 123 USD");
        data.setPostTitle("WH USD ACCOUNT");
        listData.add(0,data);
        data = new PostData();
        data.setPostDate("Available balance: 1100 EUR");
        data.setPostTitle("WH EUR ACCOUNT");
        listData.add(1,data);
        data = new PostData();
        data.setPostDate("Available balance: 123 UAH");
        data.setPostTitle("WH UAH ACCOUNT");
        listData.add(2,data);
        data = new PostData();
        data.setPostDate("Click for add new currency");
        data.setPostTitle("ADD NEW WH ACCOUNT");
        listData.add(3,data);
        data = new PostData();
        data.setPostDate("Click for delete currency");
        data.setPostTitle("REMOVE WH ACCOUNT");
        listData.add(4,data);
        return listData;

    }
    public ArrayList<PostData> InsertList2() {
        listData = new ArrayList<>();
        data = new PostData();
        data.setPostDate("VISA USD card");
        data.setPostTitle("Available balance: 155 000 UAH");
        listData.add(0,data);
        data = new PostData();
        data.setPostDate("MasterCard EUR card");
        data.setPostTitle("Available balance: 1 500 EUR");
        listData.add(1,data);
        data = new PostData();
        data.setPostDate("WebMoney account");
        data.setPostTitle("Available balance: 3 000 USD");
        listData.add(2,data);

        return listData;
    }
}
