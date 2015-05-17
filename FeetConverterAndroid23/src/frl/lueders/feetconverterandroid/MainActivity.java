package frl.lueders.feetconverterandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;

public class MainActivity extends Activity {
	
	private double conversion = 0.3048;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toast.makeText(this, "Sample message", Toast.LENGTH_LONG).show();
            }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       //getMenuInflater().inflate(R.menu.main, menu);      
        return true;
    
    }
    
    private double convert(float inputValue, double constant) {
    	return inputValue * constant; 
    } 
    
    /*
     * round to 2 decimal places
     */
    double round(double in) {
    	return (double)Math.round(in * 100) / 100;  
    }
    
    
    public void onClick(View view) {
		TextView guiOutput = (TextView) findViewById(R.id.textView1);
		EditText guiInput = (EditText) findViewById(R.id.editText1);
	    float inputValue = Float.parseFloat(guiInput.getText().toString());
	    double outputValue = 0; 
	    
    	switch (view.getId()) {
	    	case R.id.button1: {
	    		//Toast.makeText(this, "Button 1", Toast.LENGTH_LONG).show();
	    	    outputValue = convert(inputValue, conversion);
	    	    break; 
	    	}
	    	
	    	case R.id.button2: {
	    		//Toast.makeText(this, "Button 2", Toast.LENGTH_LONG).show();
	    		outputValue = convert(inputValue, 1/conversion);
	    		break; 
	    	}    	
	    	
	    	default: 
	    		outputValue = 0; 
    	}
    	
    	if (outputValue !=0) {
    		outputValue = round(outputValue);
    		guiOutput.setText(String .valueOf(outputValue));
    	}
    	
    } 	

}
