package com.example.tasktracker;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.view.View;

public class CreateTask extends Activity implements View.OnClickListener{
	
	//Test
	private ListView taskView;

	private TextView priorityValue;
	private SeekBar priority;
	private Button btnCreate, btnBack;
	private EditText taskName;
	private String name;
	private ListView myList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_task);
		
		priorityValue = (TextView) findViewById(R.id.tvValue);
		taskName = (EditText) findViewById(R.id.etTaskName);
		priority = (SeekBar) findViewById(R.id.priority);
		btnCreate = (Button) findViewById(R.id.create);
		btnBack = (Button) findViewById(R.id.back);
		
		
		 taskView = (ListView) findViewById(R.id.myTask);
	    	final ArrayList<String> taskList = new ArrayList<String>();
	    	final ArrayAdapter<String> taskArray;
	    	taskArray = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, taskList);
	    	taskView.setAdapter(taskArray);

		getPriority();
		btnCreate.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		
    	Intent i = getIntent();
    	Bundle extras = i.getExtras();
    	if(extras !=null){
    		String str = extras.getString("task");
    		if(!(str.isEmpty())){
    	    	taskList.add(0, str);
    	    	taskArray.notifyDataSetChanged();
    		}   			
    	}
		
	}

	private void getPriority() {
		// TODO Auto-generated method stub
		
			priority.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub
				priorityValue.setText(String.valueOf(priority.getProgress()));
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			});
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.back:
			Intent intentBack = new Intent(CreateTask.this, TaskView.class);
			startActivity(intentBack);
			break;
		case R.id.create:
			name = taskName.getText().toString();
			Bundle bndl = new Bundle();
			bndl.putString("task", name);
			Intent intentCreate = new Intent(CreateTask.this, TaskView.class);
			intentCreate.putExtras(bndl);
			startActivity(intentCreate);
			break;
		}
	}

}
