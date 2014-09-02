package com.stuttgart.planetsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

public class PlanetsListActivity extends Activity {

	Intent in;
	ImageView imageview_1;
	ListView listview_1;
	PlanetsAdapter planetadapter;
	int mass;
	int radius;
	String name;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		in = getIntent();
		mass=in.getIntExtra("mass", 0);
		radius=in.getIntExtra("radius", 0);
		name=in.getStringExtra("name");
		
		Log.d("aaa", "Secondactivity mass "+ mass+" rad "+ radius);
		
		imageview_1 = (ImageView)findViewById(R.id.imageView1);
		listview_1 = (ListView)findViewById(R.id.listView1);
		//mass = position * 100;
		//radius = position * 200;
		planetadapter = new PlanetsAdapter(this, mass, radius);
		listview_1.setAdapter(planetadapter);
	}
}
