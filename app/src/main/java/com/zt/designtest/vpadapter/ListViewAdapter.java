package com.zt.designtest.vpadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zt.designtest.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/15.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private Context context;

    public ListViewAdapter(Context context,ArrayList<String>datas) {
        this.list = datas;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.swipe_list_item, null);
            vh = new ViewHolder();
            vh.textView = (TextView) convertView.findViewById(R.id.swipe_list_item_tv);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.textView.setText(list.get(position));
        return convertView;
    }
    class ViewHolder{
        private TextView textView;
    }
}
