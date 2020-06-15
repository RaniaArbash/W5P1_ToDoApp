package com.example.w5p1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class AddToDoTaskActivity extends AppCompatActivity {
ImageView imageView;

    DatePicker picker;
    EditText taskText;
    private final int PICK_IMAGE_CAMERA = 1, PICK_IMAGE_GALLERY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);
    }

    public void save_task(View view) {
        picker=(DatePicker)findViewById(R.id.datapicker);
        taskText = (EditText) findViewById(R.id.task_id);

        String date = "Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear();
        Log.d("date",date);

        Date taskDate = new Date();
        taskDate.setMonth(picker.getMonth());
        taskDate.setYear(picker.getYear());
        taskDate.setDate(picker.getDayOfMonth());

        ToDoTask newTask = new ToDoTask(taskText.getText().toString(),taskDate.toString());

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",newTask);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }

}
