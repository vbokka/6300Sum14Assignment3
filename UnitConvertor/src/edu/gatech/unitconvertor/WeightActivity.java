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

public class WeightActivity extends ActionBarActivity {
	
	// Convert from Pounds to KG
	public String PoundToKG(double Pound) {
    	double KG = Pound / 2.20462;
    	return String.valueOf(KG);
    	
    }
    
	// Convert from KG  to  Pounds
    public String KGToPound (double KG) {
    	
    	double Pound = KG*2.20462;
    	return String.valueOf(Pound);
    }

    public void handleClick(View view){
    	boolean checked = ( (RadioButton) view).isChecked();
    	EditText txt = (EditText)  findViewById(R.id.Weight);
    	
    	double Weight;
    	
    	try  
  	  {  

    		  //Check for exception in converting the input to numbers

    	    
    		 Weight = Double.parseDouble(txt.getText().toString());
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
    	
    	// Based on the radio button checked  call the appropriate method
    	
    	switch(view.getId() ) {
    	case R.id.KG:
    		if(checked)
    			txt.setText(PoundToKG(Weight));
    		break;
    		
    	case R.id.Pound:
    		if(checked)
    			txt.setText(KGToPound(Weight));
    		break;
    	}
    }


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_weight,
					container, false);
			return rootView;
		}
	}

}
