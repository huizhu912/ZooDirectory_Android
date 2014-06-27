package com.example.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ZooInformation extends MainActivity {
	String phoneNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zoo_information);
		
		phoneNumber = getString(R.string.phone_number);
		TextView phone = (TextView)findViewById(R.id.phone);
		phone.setText("("+phoneNumber+")");
		
		phone.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
				startActivity(i);				
			}
			
		}); 
		
		ImageView iconCall = (ImageView)findViewById(R.id.iconCall);
		iconCall.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
				startActivity(i);		
			}
			
		});
		
	}	
}
