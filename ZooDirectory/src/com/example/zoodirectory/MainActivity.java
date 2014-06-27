package com.example.zoodirectory;

import java.lang.reflect.Field;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends Activity {
	CustomListAdapter adapter;
	int index;
	Intent intent;
	String[] labels = {"Tiger", "Lion", "Zebra", "Cheetah", "Dinosaur"};
	int[] desc = {R.string.tiger_desc, R.string.lion_desc, R.string.zebra, R.string.cheeta, R.string.dinosaur};
	int[] thumbnails = {R.drawable.tiger_small, R.drawable.lion_small, R.drawable.zebra_small, R.drawable.cheetah_small, R.drawable.dinosaur_small};
	int[] images = {R.drawable.tiger_large, R.drawable.lion_large, R.drawable.zebra_large, R.drawable.cheetah_large, R.drawable.dinosaur_large};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ListView lv = (ListView)findViewById(R.id.listView1);
		adapter = new CustomListAdapter(this, R.layout.custom_list_adapter, labels, thumbnails); 
		lv.setAdapter(adapter);
		//setOnItemClickListener, create intent, pass label, image source, short description to AnimalDetail.class
		
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View clicked, int position,
					long rowId) {
				//Toast.makeText(MainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
				//Toast.makeText(MainActivity.this, "imageId = " + images[position], Toast.LENGTH_SHORT).show();
				
				if (position == (labels.length - 1) ) {
					index = position;
					showAlertDialog(MainActivity.this);
				}
				else {
					Intent i = new Intent(MainActivity.this, AnimalDetail.class);
					i.putExtra("name", labels[position]);
					i.putExtra("image", images[position]);
					i.putExtra("desc", desc[position]);
					startActivity(i);
				}
				
			}
			
		});
	}
	
	public void showAlertDialog(MainActivity mainActivity){
			new AlertDialog.Builder(mainActivity)
				.setTitle("Alert")
				.setMessage("This animal is very scary. Do you want to proceed?")
				.setIcon(R.drawable.ic_alert)
				.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent i = new Intent(MainActivity.this, AnimalDetail.class);
						i.putExtra("name", labels[index]);
						i.putExtra("image", images[index]);
						i.putExtra("desc", desc[index]);
						startActivity(i);					
					}
				})
				.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {}
				})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
					@Override
					public void onClick(DialogInterface dialog, int which) {}
				})
				.create()
				.show();
				
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		// code borrowed from stackoverflow, which forces the overflow menu to show up
		try {
		    ViewConfiguration config = ViewConfiguration.get(MainActivity.this);
		    Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
		    if (menuKeyField != null) {
		        menuKeyField.setAccessible(true);
		        menuKeyField.setBoolean(config, false);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();
		switch(id){
			case R.id.information:
				intent = new Intent(MainActivity.this, ZooInformation.class);
				startActivity(intent);
				return true;
			case R.id.uninstall:
				intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE, Uri.parse("package:com.example.zoodirectory"));
				startActivity(intent);					
				return true;
			default: 
				Toast.makeText(MainActivity.this,"id is not available: " + id + ", " + R.id.information,Toast.LENGTH_LONG).show();
				return super.onOptionsItemSelected(item);
		}

	}

}
