package edu.gatech.unitconvertor;

import edu.gatech.unitconvertor.*;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.os.Build;

public class DistanceActivity extends ActionBarActivity {

	
	//Convert from  Miles To KM
public String MilesTokm(double miles) {
    	double km = miles *1.609;
    	return String.valueOf(km);
    	
    }
    //Convert from KM to Miles
    public String kmToMiles (double km) {
    	
    	double miles = km/1.609;
    	return String.valueOf(miles);
    }
    
    
    public void handleClick(View view){
    	boolean checked = ( (RadioButton) view).isChecked();
    	EditText txt = (EditText)  findViewById(R.id.text1);
    	double distance ;
    	try  
  	  {  
    		 distance = Double.parseDouble(txt.getText().toString());
  	  }  
  	  catch(NumberFormatException nfe)  
  	  {  
  		  //Check for exception in converting the input to numbers
  		Context context = getApplicationContext();
  		CharSequence text = "Only numeric input please";
  		int duration = Toast.LENGTH_SHORT;
// Display a notification
  		Toast toast = Toast.makeText(context, text, duration);
  		toast.show();
  	    return ;
  	  }  
  	  
    	
   
    	
    	// Based on the radio button checked  call the appropriate method
    	
    	switch(view.getId() ) {
    	case R.id.Miles:
    		if(checked)
    			txt.setText(kmToMiles(distance));
    		break;
    		
    	case R.id.KM:
    		if(checked)
    			txt.setText(MilesTokm(distance));
    		break;
    	}
    }


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_distance);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.distance, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_distance,
					container, false);
			return rootView;
		}
	}

}
