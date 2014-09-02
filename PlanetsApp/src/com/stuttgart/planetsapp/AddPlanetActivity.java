package com.stuttgart.planetsapp;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlanetActivity extends Activity {
	Intent in;
	EditText editText1, editText2, editText3;
	Button button1;
	String name;
	int mass, radius;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		setClickListners();
	}

	private void setClickListners() {

		button1 = (Button) findViewById(R.id.button1);
	//	textView1=(TextView) findViewById(R.id.textView1);
	//	textView2=(TextView) findViewById(R.id.textView2);
	//	textView3=(TextView) findViewById(R.id.textView3);
		
		editText1=(EditText) findViewById(R.id.editText1);
		editText2=(EditText) findViewById(R.id.editText2);
		editText3=(EditText) findViewById(R.id.editText3);
		
		button1.setOnClickListener(new View.OnClickListener() {		
			
			
			@Override
			public void onClick(View arg0) {
				//Intent in = new Intent(ThirdActivity.this, FourthActivity.class);
				
				Log.d("aaa", "ThirdActivity name "+editText1.getText());
				Log.d("aaa", "ThirdActivity mass "+editText2.getText());
				Log.d("aaa", "ThirdActivity radius "+editText3.getText());
				
				/*in.putExtra("name", editText1.getText().toString());
				in.putExtra("mass", Integer.parseInt(editText2.getText().toString()));
				in.putExtra("radius", Integer.parseInt(editText3.getText().toString()));

				
				startActivity(in);*/
				
				saveTOParse();
			}
		});
	}

	protected void saveTOParse() {

		ParseObject parseobject = new ParseObject("Planets");
		parseobject.put("name",  editText1.getText().toString());
		parseobject.put("mass",  Integer.parseInt(editText2.getText().toString()));
		parseobject.put("radius",  Integer.parseInt(editText3.getText().toString()));
		
		Log.d("aaa", "FourthActivity name "+name);
		Log.d("aaa", "FourthActivity mass "+mass);
		Log.d("aaa", "FourthActivity mass "+radius);

		
		parseobject.saveInBackground(new SaveCallback() {
			
			@Override
			public void done(ParseException e) {
				if(e==null)
				{
			Toast.makeText(getApplicationContext(), "Planet successfully added", Toast.LENGTH_LONG).show();
			finish();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
	}
}
