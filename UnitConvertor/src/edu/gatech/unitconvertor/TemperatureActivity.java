package edu.gatech.unitconvertor;



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

public class TemperatureActivity extends ActionBarActivity {
	
	
	
// convert from Farenheit to Celsius
	public String FarenToCel(double Faren) {
    	double Cel = (Faren-32) * 5/9;
    	return String.valueOf(Cel);
    	
    }
    // Convert from Celsius to Farenheit
    public String CelToFaren (double Cel) {
    	
    	double Faren = Cel* 9 /5 + 32 ;
    	return String.valueOf(Faren);
    }
    
    
    // Handle click
    
    public void handleClick(View view){
    	
    	  
    	
    	boolean checked = ( (RadioButton) view).isChecked();
    	    	EditText txt = (EditText)  findViewById(R.id.temp);
    	    	
    	    	double Temp;
    	    	
    	    	

    	    	  //Check for exception in converting the input to numbers
    	    	
    	    	try  
    	    	  {  
    	    		 Temp = Double.parseDouble(txt.getText().toString());
    	    	  }  
    	    	  catch(NumberFormatException nfe)  
    	    	  {  
    	    		  
    	    		// Display a notification
    	    	  		Context context = getApplicationContext();
    	    	  		CharSequence text = "Only numeric input please";
    	    	  		int duration = Toast.LENGTH_SHORT;

    	    	  		Toast toast = Toast.makeText(context, text, duration);
    	    	  		toast.show();
    	    	    return ;
    	    	  }  
    	//double Temp = Double.parseDouble(txt.getText().toString());
    	
    	    	
    	    	// Based on the radio button checked  call the appropriate method
    	switch(view.getId() ) {
    	case R.id.Faren:
    		if(checked)
    			txt.setText(CelToFaren(Temp));
    		break;
    		
    	case R.id.Cel:
    		if(checked)
    			txt.setText(FarenToCel(Temp));
    		break;
    	}
    }



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temperature);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.temperature, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_temperature,
					container, false);
			return rootView;
		}
	}

}
