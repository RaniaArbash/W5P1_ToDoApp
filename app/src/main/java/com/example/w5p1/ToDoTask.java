package com.example.w5p1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ToDoTask implements Parcelable {
    String task;
    String time;


    public ToDoTask(String task, String time) {
        this.task = task;
        this.time = time;
    }

    protected ToDoTask(Parcel in) {
        task = in.readString();
        time = in.readString();
    }

    public static final Creator<ToDoTask> CREATOR = new Creator<ToDoTask>() {
        @Override
        public ToDoTask createFromParcel(Parcel in) {
            return new ToDoTask(in);
        }

        @Override
        public ToDoTask[] newArray(int size) {
            return new ToDoTask[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(task);
        dest.writeString(time);
    }
}
