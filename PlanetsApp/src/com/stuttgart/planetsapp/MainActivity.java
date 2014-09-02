package com.stuttgart.planetsapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class MainActivity extends Activity {

	ListView listview1;
	
	ArrayList<String> planetNames = new ArrayList<>();
	ArrayList<Integer> massArray = new ArrayList<>();
	ArrayList<Integer> radiusArray = new ArrayList<>();

//	Button button1;
	ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		progressBar=(ProgressBar)findViewById(R.id.progress);
//		getItemsFromParse();

//		setClickListners();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		getItemsFromParse();
	}

	private void getItemsFromParse() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Planets");

		progressBar.setVisibility(View.VISIBLE);
		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> parseObject, ParseException e) {

				Log.d("aaa", "inside callback");
				if (e == null) {

					Log.d("aaa", "no exception, size is: " + parseObject.size());
					planetNames.clear();
					massArray.clear();
					radiusArray.clear();
					for (int i = 0; i < parseObject.size(); i++) {
						String name = parseObject.get(i).getString("name");
						int mass = parseObject.get(i).getNumber("mass").intValue();
						int radius = parseObject.get(i).getNumber("radius").intValue();
						
						Log.d("aaa", "Callback mass "+mass+" rad "+radius);

					
						
						planetNames.add(name);
						massArray.add(mass);
						radiusArray.add(radius);
					}

					progressBar.setVisibility(View.GONE);
					setOnItemClickListeners();
				}

			}
		});
				
	
	}



/*	private void setClickListners() {

		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent in = new Intent(MainActivity.this, ThirdActivity.class);
				startActivity(in);
			}
		});
	}
	*/

	private void setOnItemClickListeners() {

		listview1 = (ListView) findViewById(R.id.listview_1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, planetNames);
		listview1.setAdapter(adapter);

		listview1.setOnItemClickListener(new ListView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {

				Intent in = new Intent(MainActivity.this, PlanetsListActivity.class);
				in.putExtra("Position", position);
				in.putExtra("name", planetNames.get(position));
				in.putExtra("mass", massArray.get(position));
				in.putExtra("radius", radiusArray.get(position));
				Log.d("aaa", "Listner mass "+ massArray.get(position)+" rad "+ radiusArray.get(position));
				startActivity(in);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.add) {
			
			Intent in = new Intent(MainActivity.this, AddPlanetActivity.class);
			startActivity(in);
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
