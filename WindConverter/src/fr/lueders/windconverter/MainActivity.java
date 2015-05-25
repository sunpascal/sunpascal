package fr.lueders.windconverter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends SwipeActivity {
	
	Resources res;
	TextView guiOutputValue;
	TextView guiOutputBeaufortNumber;
	TextView guiOutputBeaufortDescr;
	TextView guiOutputBeaufortEffectSea;
	TextView guiOutputBeaufortEffectLand;
	ImageView imageView1;	
	EditText guiInput;
	Converter converter;
	
	
    public void onClick(View view) {

	    float inputValue = Float.parseFloat(guiInput.getText().toString());
	    double outputValue = 0; 
	    Beaufort b = null; 
	    String appendUnit = ""; 
	    
    	switch (view.getId()) {
    		// user entered value in knots
	    	case R.id.button1: {
	    		//Toast.makeText(this, "Button 1", Toast.LENGTH_LONG).show();
	    	    outputValue = converter.convert(inputValue, converter.getConversionConst());
	    	    b = converter.getBeaufortFromKnots((int)inputValue);  // todo: check rounding
	    	    appendUnit = " km/h";
	    	    break; 
	    	}
	    	
	    	// user entered value in km/h
	    	case R.id.kmh: {
	    		outputValue = converter.convert(inputValue, 1/converter.getConversionConst());
	    		 b = converter.getBeaufortFromKnots((int)outputValue);  
	    		 appendUnit = " knots";
	    		break; 
	    	}    	
	    	
	    	default: 
	    		outputValue = 0; 
    	}
    	
    	updateGUI(b, outputValue, appendUnit); 
    	
    	
    }

	private void updateGUI(Beaufort b, double outputValue, String appendUnit) {
	 	if (outputValue >=0 & b != null) {
    		outputValue = converter.round(outputValue);
    		guiOutputValue.setText(String .valueOf(outputValue) + appendUnit);
    		guiOutputBeaufortNumber.setText(Integer.toString(b.n));
    		guiOutputBeaufortDescr.setText(b.descr);
    		guiOutputBeaufortEffectSea.setText(b.wirkungAufSee);
    		guiOutputBeaufortEffectLand.setText(b.wirkungAufLand);
    		
    		Drawable drawable = null;
    	
    		switch (b.n) {	
	    		case 0: drawable = res.getDrawable(R.drawable.beaufort_scale_0); break;	
	    		case 1: drawable = res.getDrawable(R.drawable.beaufort_scale_1); break;	
	    		case 2: drawable = res.getDrawable(R.drawable.beaufort_scale_2); break;	
	    		case 3: drawable = res.getDrawable(R.drawable.beaufort_scale_3); break;	
	    		case 4: drawable = res.getDrawable(R.drawable.beaufort_scale_4); break;	
	    		case 5: drawable = res.getDrawable(R.drawable.beaufort_scale_5); break;	
	    		case 6: drawable = res.getDrawable(R.drawable.beaufort_scale_6); break;	
	    		case 7: drawable = res.getDrawable(R.drawable.beaufort_scale_7); break;	
	    		case 8: drawable = res.getDrawable(R.drawable.beaufort_scale_8); break;	
	    		case 9: drawable = res.getDrawable(R.drawable.beaufort_scale_9); break;	
	    		case 10: drawable = res.getDrawable(R.drawable.beaufort_scale_10); break;	
	    		case 11: drawable = res.getDrawable(R.drawable.beaufort_scale_11); break;
	    		case 12: drawable = res.getDrawable(R.drawable.beaufort_scale_12); break;
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
		
    	converter = new Converter(); 
    	
		guiOutputValue = (TextView) findViewById(R.id.textView1);
		guiOutputBeaufortNumber = (TextView) findViewById(R.id.windForce);
		guiOutputBeaufortDescr = (TextView) findViewById(R.id.windForceDescription);
		guiOutputBeaufortEffectSea = (TextView) findViewById(R.id.aufSee);
		guiOutputBeaufortEffectLand = (TextView) findViewById(R.id.textView4);
		imageView1 = (ImageView) findViewById(R.id.imageView);
		guiInput = (EditText) findViewById(R.id.input);		
		
		guiOutputValue.setText("");
		guiOutputBeaufortNumber.setText("");
		guiOutputBeaufortDescr.setText("");
		
		Beaufort b = converter.getBeaufort(0);
		int knots = converter.getKnotsFromBeaufort(0);
		updateGUI(b, knots, " knots");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void previous() {
		int i_b = 0;
		if (guiOutputBeaufortNumber.getText().length() > 0)
			i_b = Integer.parseInt((String) guiOutputBeaufortNumber.getText());
		if (i_b > 0)
			i_b = i_b - 1; 
		Beaufort b = converter.getBeaufort(i_b);
		int knots = converter.getKnotsFromBeaufort(i_b);
		updateGUI(b, knots, " knots");
//		guiInput.setText(""+knots);
	}

	@Override
	protected void next() {
		int i_b = 0;
		if (guiOutputBeaufortNumber.getText().length() > 0)
			i_b = Integer.parseInt((String) guiOutputBeaufortNumber.getText());
		if (i_b < 12)
			i_b = i_b + 1; 		
		Beaufort b = converter.getBeaufort(i_b);
		int knots = converter.getKnotsFromBeaufort(i_b);
		updateGUI(b, knots, " knots");
//		guiInput.setText(""+knots);
//		Toast.makeText(this, "right", 500).show();
	}
	



	


}
