package Color.Finder.Assignment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    NumberPicker red;
    NumberPicker green;
    NumberPicker blue;

    TextView theColorView;

    TextView theHexView;

    static int theCombinedColor;

    final int max = 255;
    final int min = 0;

    String hex;
    
    boolean wasCalled = false;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent intent = getIntent();
        wasCalled  = intent.getExtras().getBoolean("calledByProgram");

        
        if(wasCalled){
            Button finishButton = (Button) findViewById(R.id.finishButton);
            finishButton.setVisibility(View.VISIBLE);
        }
    
        setupNumberPickers();

    }

    /**
     *
     */
    private void setupNumberPickers() {
        red = (NumberPicker) findViewById(R.id.redPicker);
        green = (NumberPicker) findViewById(R.id.greenPicker);
        blue = (NumberPicker) findViewById(R.id.bluePicker);

        theColorView = (TextView) findViewById(R.id.theColorDisplay);
        theHexView = (TextView) findViewById(R.id.theHexDisplay);

        //Set Pickers Max Value
        red.setMaxValue(max);
        green.setMaxValue(max);
        blue.setMaxValue(max);

        //Set Pickers Min Value
        red.setMinValue(min);
        green.setMinValue(min);
        blue.setMinValue(min);

        //Set Start Value
        red.setValue(255);
        green.setValue(255);
        blue.setValue(255);

        theCombinedColor = Color.rgb(red.getValue(),
                green.getValue(), blue.getValue());
        setTextViewColor(theCombinedColor);
        hex = Integer.toHexString(Color.rgb(red.getValue(),
                green.getValue(), blue.getValue()));

        theHexView.setTextColor(Color.rgb(red.getValue(),
                green.getValue(), blue.getValue()));
        theHexView.setText("HEX Value #" + hex.toUpperCase().substring(2));

        // Listener for the NumberPicker Red
        red.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                    int newVal) {
                theCombinedColor = Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue());
                setTextViewColor(theCombinedColor);
                hex = Integer.toHexString(Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue()));

                theHexView.setTextColor(Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue()));
                theHexView.setText("HEX Value #" + hex.toUpperCase().substring(2));

            }
        });
        // Listener for the NumberPicker Blue
        blue.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                    int newVal) {
                theCombinedColor = Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue());
                setTextViewColor(theCombinedColor);
                hex = Integer.toHexString(Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue()));

                theHexView.setTextColor(Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue()));
                theHexView.setText("HEX Value #" + hex.toUpperCase().substring(2));

            }
        });

        // Listener for the NumberPicker Green
        green.setOnValueChangedListener(new OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                    int newVal) {
                theCombinedColor = Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue());
                setTextViewColor(theCombinedColor);
                hex = Integer.toHexString(Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue()));

                theHexView.setTextColor(Color.rgb(red.getValue(),
                        green.getValue(), blue.getValue()));
                theHexView.setText("HEX Value #" + hex.toUpperCase().substring(2));

            }
        });
    }

    /**
     *
     * @param colorToSet
     */
    public void setTextViewColor(int colorToSet) {
        theColorView.setBackgroundColor(colorToSet);
    }

    public void finishActivity(View v){
        Intent _resultColor = new Intent();
        _resultColor.putExtra("color", theCombinedColor);
        setResult(RESULT_OK, _resultColor);
        finish();
        
    }

    




}
