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
    Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcButton = (Button)findViewById(R.id.calculate);
        userWeight = (EditText)findViewById(R.id.userInputWeight);
        userReps = (EditText)findViewById(R.id.userInputReps);

        calcButton.setOnClickListener(new View.OnClickListener() {

            // calculate the one rep max and display it
            public void onClick(View v) {
                // get the user input weight
                userWeightString = userWeight.getText().toString();
                try {
                    weight = Integer.parseInt(userWeightString);
                } catch (NumberFormatException e){
                    // not an Integer
                }

                // get the user input reps
                userRepsString = userReps.getText().toString();
                try {
                    reps = Integer.parseInt(userRepsString);
                } catch (NumberFormatException e){
                    // not an Integer
                }

                max = weight + reps;
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
