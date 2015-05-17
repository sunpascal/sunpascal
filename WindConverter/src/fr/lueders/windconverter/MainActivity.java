package fr.lueders.windconverter;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Resources res;
	
	
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
		TextView guiOutputBeaufortEffectSea = (TextView) findViewById(R.id.aufSee);
		TextView guiOutputBeaufortEffectLand = (TextView) findViewById(R.id.textView4);
		ImageView imageView1 = (ImageView) findViewById(R.id.imageView);
		
		EditText guiInput = (EditText) findViewById(R.id.input);
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
	    	case R.id.kmh: {
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
    		guiOutputBeaufortEffectSea.setText(b.wirkungAufSee);
    		guiOutputBeaufortEffectLand.setText(b.wirkungAufLand);
    		
    		Drawable drawable = null;
    	
    		switch (b.n) {	
	    		case 0: drawable = res.getDrawable(R.drawable.beaufort_scale_0); break;	
	    		case 1: drawable = res.getDrawable(R.drawable.beaufort_scale_1); break;	
	    		case 2: drawable = res.getDrawable(R.drawable.beaufort_scale_3); break;	
	    		case 3: drawable = res.getDrawable(R.drawable.beaufort_scale_4); break;	
	    		case 4: drawable = res.getDrawable(R.drawable.beaufort_scale_5); break;	
	    		case 5: drawable = res.getDrawable(R.drawable.beaufort_scale_6); break;	
	    		case 6: drawable = res.getDrawable(R.drawable.beaufort_scale_7); break;	
	    		case 7: drawable = res.getDrawable(R.drawable.beaufort_scale_8); break;	
	    		case 8: drawable = res.getDrawable(R.drawable.beaufort_scale_9); break;	
	    		case 9: drawable = res.getDrawable(R.drawable.beaufort_scale_10); break;	
	    		case 10: drawable = res.getDrawable(R.drawable.beaufort_scale_11); break;	
	    		case 11: drawable = res.getDrawable(R.drawable.beaufort_scale_12); break;	
    		}
    		
    		if (drawable != null) {
    			imageView1.setImageDrawable(drawable);
    			imageView1.setVisibility(View.VISIBLE);
    		}
    		else {
    			imageView1.setVisibility(View.INVISIBLE);
    		}
    	
    } 		
    	
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		res = getResources();
		
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
