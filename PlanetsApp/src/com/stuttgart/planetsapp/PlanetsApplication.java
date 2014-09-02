package com.stuttgart.planetsapp;

import com.parse.Parse;
import android.app.Application;

public class PlanetsApplication extends Application{

	@Override
	public void onCreate() {
		
		super.onCreate();
		
		Parse.initialize(this, "o6bmRVSJXXzSIXGvFCj1QliPN9iyFchoZTQObiS3", "zLkhcCulnS66z7ZzLVvrx70Mp9esAtr5hxv9a1Oe");
		/*ParseObject testObject = new ParseObject("Planets");
		testObject.put("name", "mercury");
		testObject.put("mass", "2000");
		testObject.put("radius", "150");
		testObject.saveInBackground();*/
	}
}
