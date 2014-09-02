package com.stuttgart.planetsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PlanetsAdapter extends BaseAdapter{

	LayoutInflater layoutInflater;
	Context context;
	int mass;
	int radius;
	
	public PlanetsAdapter(Context context, int mass, int radius) {
		this.context = context;
		this.mass = mass;
		this.radius = radius;
		Log.d("aaa", "adapter mass "+ mass+" rad "+ radius);
		layoutInflater = (LayoutInflater) (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup container) {
		// TODO Auto-generated method stub
		
		if (view== null) {
			view=layoutInflater.inflate(R.layout.row_item, container, false);
					
		}
		TextView textview1 = (TextView) view.findViewById(R.id.textView1);
		TextView textview2 = (TextView) view.findViewById(R.id.textView2);
		
		if (position == 0){
			textview1.setText("Mass");
			textview2.setText(""+mass);
		}
		
		if (position == 1){
			textview1.setText("Radius");
			textview2.setText(""+radius);
		}
		
		return view;
	}
}
