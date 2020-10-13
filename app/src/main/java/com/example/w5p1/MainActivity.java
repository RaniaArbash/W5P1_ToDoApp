package com.example.w5p1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CustomAdapter customAdapter;
    ListView simpleList;
    ArrayList<ToDoTask> toDoTasks = new ArrayList<ToDoTask>(5);
    int LAUNCH_SECOND_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            toDoTasks = savedInstanceState.getParcelableArrayList("todolist");
        }
        else {
            toDoTasks = new ArrayList<ToDoTask>(5);
        }

        simpleList = (ListView) findViewById(R.id.simpleListView);
        customAdapter = new CustomAdapter(getApplicationContext(), toDoTasks);
        simpleList.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.addcountry,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.add_country_id: {
                Intent myIntent = new Intent(this, AddToDoTaskActivity.class);
                startActivityForResult(myIntent,LAUNCH_SECOND_ACTIVITY);

            }
        }
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                ToDoTask result=data.getParcelableExtra("result");
                Log.d("task","value");
                toDoTasks.add(result);

               // customAdapter = new CustomAdapter(getApplicationContext(), toDoTasks);
                //simpleList.setAdapter(customAdapter);

               customAdapter.toDoTasks = toDoTasks;
                customAdapter.notifyDataSetChanged();

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("todolist",toDoTasks);

    }
}

