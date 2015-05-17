package fr.lueders.windconverter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	/**
	 * displays information about given Beaufort force 
	 * @param force beaufort force number for which to load info
	 */
	private void loadBeaufort(int force) {
		// load number, descr. text (land+see), img
		
	}
	
    public void onClick(View view) {
    	Converter c = new Converter(); 
    	double conversion = c.getConversionConst();
    	
		TextView guiOutputValue = (TextView) findViewById(R.id.textView1);
		TextView guiOutputBeaufortNumber = (TextView) findViewById(R.id.TextView01);
		TextView guiOutputBeaufortDescr = (TextView) findViewById(R.id.TextView02);
		EditText guiInput = (EditText) findViewById(R.id.editText1);
	    float inputValue = Float.parseFloat(guiInput.getText().toString());
	    double outputValue = 0; 
	    Beaufort b = null; 
	    String appendUnit = ""; 
	    
    	switch (view.getId()) {
    		// user entered value in knots
	    	case R.id.button1: {
	    		//Toast.makeText(this, "Button 1", Toast.LENGTH_LONG).show();
	    	    outputValue = c.convert(inputValue, conversion);
	    	    b = c.getBeaufort((int)inputValue);  // todo: check rounding
	    	    appendUnit = " km/h";
	    	    break; 
	    	}
	    	
	    	// user entered value in km/h
	    	case R.id.button2: {
	    		outputValue = c.convert(inputValue, 1/conversion);
	    		 b = c.getBeaufort((int)outputValue);  
	    		 appendUnit = " knots";
	    		break; 
	    	}    	
	    	
	    	default: 
	    		outputValue = 0; 
    	}
    	
    	if (outputValue !=0 & b != null) {
    		outputValue = c.round(outputValue);
    		guiOutputValue.setText(String .valueOf(outputValue) + appendUnit);
    		guiOutputBeaufortNumber.setText("Windstärke: " + Integer.toString(b.n));
    		guiOutputBeaufortDescr.setText(b.descr);
    	}
    	
    } 		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView guiOutputValue = (TextView) findViewById(R.id.textView1);
		TextView guiOutputBeaufortNumber = (TextView) findViewById(R.id.TextView01);
		TextView guiOutputBeaufortDescr = (TextView) findViewById(R.id.TextView02);
		guiOutputValue.setText("");
		guiOutputBeaufortNumber.setText("");
		guiOutputBeaufortDescr.setText("");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

				
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	


}
