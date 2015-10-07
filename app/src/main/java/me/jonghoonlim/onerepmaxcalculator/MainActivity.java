package me.jonghoonlim.onerepmaxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int max;
    int weight;
    int reps;
    String userWeightString, userRepsString;
    EditText userWeight, userReps;
    Button calcButton, resetAll;
    TextView displayMax, display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcButton = (Button)findViewById(R.id.calculate);
        resetAll = (Button)findViewById(R.id.resetButton);
        userWeight = (EditText)findViewById(R.id.userInputWeight);
        userReps = (EditText)findViewById(R.id.userInputReps);
        displayMax = (TextView)findViewById(R.id.maxDisplay);
        display = (TextView)findViewById(R.id.display);
        weight = 0;
        reps = 0;

        // call the calculate method
        calculate();

        // call the reset method
        reset();
    }

    // method to calculate the one rep max
    public void calculate() {

        calcButton.setOnClickListener(new View.OnClickListener() {

            // calculate the one rep max and display it
            public void onClick(View v) {
                // get the user input weight
                userWeightString = userWeight.getText().toString();
                try {
                    weight = Integer.parseInt(userWeightString);
                } catch (NumberFormatException e) {
                    // not an Integer
                }

                // get the user input reps
                userRepsString = userReps.getText().toString();
                try {
                    reps = Integer.parseInt(userRepsString);
                } catch (NumberFormatException e) {
                    // not an Integer
                }

                // error checking
                if (weight >= 1000 && reps >= 1)
                    display.setText("Are you sure about that, big guy?");
                else if (weight == 0 && reps == 0)
                    display.setText("You lifted nothing???");
                else if (weight == 0 && reps >= 1)
                    display.setText("Please input the amount of weight lifted.");
                else if (weight >= 1 && reps == 0)
                    display.setText("Please input the number of reps.");
                // compute one rep max
                else {
                    double temp = 1.0;
                    temp = (temp * weight) / (1.0278- (0.0278 * reps));
                    max = (int) Math.round(temp);
                    display.setText("Your one rep max is...");
                    displayMax.setText("" + max);
                }
            }
        });
    }

    // set all fields to blank
    public void reset() {

        resetAll.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                userWeight.setText("");
                userReps.setText("");
                displayMax.setText("");
                display.setText("Your one rep max is...");
                max = 0;
                weight = 0;
                reps = 0;

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
