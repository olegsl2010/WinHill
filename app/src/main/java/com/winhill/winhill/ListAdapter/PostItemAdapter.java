package com.winhill.winhill.ListAdapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.winhill.winhill.R;

import java.util.ArrayList;

public class PostItemAdapter extends ArrayAdapter<PostData> {


    private Activity myContext;
    private ArrayList<PostData>  datas;

    public PostItemAdapter(Context context, int textViewResourceId,
                           ArrayList<PostData> objects) {
        super(context, textViewResourceId, objects);

        myContext = (Activity) context;
        datas = objects;
    }

    static class ViewHolder {
        TextView postTitleView;
        TextView postDateView;

    }

    @Override
    public PostData getItem(int i) {

        return datas.get(i);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = myContext.getLayoutInflater();

        ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) myContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.postitem, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.postTitleView = (TextView) convertView.findViewById(R.id.postTitleLabel);
            viewHolder.postDateView= (TextView) convertView.findViewById(R.id.postDateLabel);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.postTitleView.setText(getItem(position).getPostTitle());
        viewHolder.postDateView.setText(getItem(position).getPostDate());


        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return datas.size();
    }
}
