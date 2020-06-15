package com.example.w5p1;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflter;

    ArrayList<ToDoTask> toDoTasks;

    public CustomAdapter(Context applicationContext, ArrayList<ToDoTask> toDoTasks) {
        this.context = context;
        this.toDoTasks = new ArrayList<>(toDoTasks);
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return toDoTasks.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView task = (TextView) view.findViewById(R.id.task);
        TextView task_date = (TextView) view.findViewById(R.id.task_date);
        task.setText(toDoTasks.get(i).task);
        task_date.setText(toDoTasks.get(i).time);

        return view;
    }
}