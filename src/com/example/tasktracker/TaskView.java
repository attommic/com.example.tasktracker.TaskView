package com.example.tasktracker;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TaskView extends Activity {

	//private ListView taskView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view);
        /*
        taskView = (ListView) findViewById(R.id.myTask);
    	final ArrayList<String> taskList = new ArrayList<String>();
    	final ArrayAdapter<String> taskArray;
    	taskArray = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, taskList);
    	taskView.setAdapter(taskArray);
    	*/
    	

    	
        Button btnNewTask = (Button) findViewById(R.id.NewTask);
        btnNewTask.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(TaskView.this, CreateTask.class);
				startActivity(myIntent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_task_view, menu);
        return true;
    }
}
