package com.example.danny_000.bluetoothgeosoprt;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by danny_000 on 8/20/2016.
 */
public class MyAdapter extends BaseExpandableListAdapter {

    /*
    private List<String> header_titles;
    private HashMap<String, List<String>> child_titles;

    MyAdapter(Context ctx, String[] header_titles2, HashMap<String, String[]> child_titles) {
        this.ctx = ctx;
        this.header_titles = header_titles;
        this.child_titles = child_titles;
    }
    */

    private Context ctx;
    private String[] eventTitles;
    private String[] eventInfo;
    private int pos;

    MyAdapter(Context ctx, String[] eventTitles, String[] eventInfo) {
        this.ctx = ctx;
        this.eventTitles = eventTitles;
        this.eventInfo = eventInfo;

    }

    @Override
    public int getGroupCount() {
        //   return header_titles.size();
        return eventInfo.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //    return child_titles.get(header_titles.get(groupPosition)).size();
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        //    return header_titles.get(groupPosition);
        return eventTitles[groupPosition];

    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        //    return child_titles.get(header_titles.get(groupPosition)).get(childPosition);
        return eventInfo[groupPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String) this.getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_layout, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.heading_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String) this.getChild(groupPosition, childPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_layout, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.child_item);
        textView.setText(title);
        pos = groupPosition;
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public int getEvent() {
        return pos;
    }
}
