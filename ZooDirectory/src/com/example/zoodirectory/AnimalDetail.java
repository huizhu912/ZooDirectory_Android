package com.example.zoodirectory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetail extends MainActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animal_detail);
		
		Intent i= getIntent();
		ImageView imageView = (ImageView)findViewById(R.id.image);
		imageView.setImageResource(i.getIntExtra("image",0));
		
		TextView nameView = (TextView)findViewById(R.id.name);
		nameView.setText(i.getStringExtra("name"));
		
		TextView descView = (TextView)findViewById(R.id.desc);
		descView.setText(i.getIntExtra("desc", 0));		
	}
	
}
