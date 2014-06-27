package com.example.zoodirectory;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {
	Context context;
	String[] labels;
	int[] thumbnails;
	
	public CustomListAdapter(Context context, int layoutToBeInflated,
			String[] animal, int[] images) {
		super(context, layoutToBeInflated, R.layout.custom_list_adapter, animal);
		this.context = context;
		this.labels = animal;
		this.thumbnails = images;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
		View v = layoutInflater.inflate(R.layout.custom_list_adapter, null);
		
		TextView label = (TextView)v.findViewById(R.id.label);
		ImageView thumbnail = (ImageView)v.findViewById(R.id.thumbnail);
		
		label.setText(labels[position]);
		thumbnail.setImageResource(thumbnails[position]);
		return v;
	}
	
	
}

	
