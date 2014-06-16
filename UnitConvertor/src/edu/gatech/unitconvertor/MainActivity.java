package edu.gatech.unitconvertor;

import edu.gatech.unitconvertor.*;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		//Listener for Distance button
Button btnTemp3 = (Button) findViewById(R.id.btnDistance);
		
		btnTemp3.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
			
				Intent intent  = new Intent(getApplicationContext(), DistanceActivity.class);
				startActivity(intent);
			}
			
		}
		);
		
		//Listener for Temperature button
Button btnTemp1 = (Button) findViewById(R.id.btnTemp);
		
		btnTemp1.setOnClickListener(new OnClickListener()
		{
			public void onClick(View v)
			{
			
				Intent intent  = new Intent(getApplicationContext(), TemperatureActivity.class);
				startActivity(intent);
			}
			
		}
		);
	
	
		//Listener for Weight button
	Button  btnTemp2 = (Button) findViewById(R.id.btnWeight);
	
	btnTemp2.setOnClickListener(new OnClickListener()
	{
		public void onClick(View v)
		{
		
			Intent intent  = new Intent(getApplicationContext(), WeightActivity.class);
			startActivity(intent);
		}
		
	}
	
	);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
