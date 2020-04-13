package ro.pub.cs.systems.eim.colocviu1_13.colocviu1_13;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static ro.pub.cs.systems.eim.colocviu1_13.colocviu1_13.Constants.*;

public class Colocviu1_13 extends AppCompatActivity {
    private EditText showCardinalPoints;
    private Button eastButton, westButton, northButton, southButton;
    private Button navigateToSecondaryActivityButton;
    private int lastNrPressedCardinalButtons;
    private String retainedString = "";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.east_button:
                    lastNrPressedCardinalButtons++;
                    if (showCardinalPoints.getText().toString().trim().length() <= 0) {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + EAST);
                    } else {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + ", " + EAST);
                    }
                    retainedString += showCardinalPoints.getText().toString();
                    break;
                case R.id.west_button:
                    lastNrPressedCardinalButtons++;
                    if (showCardinalPoints.getText().toString().trim().length() <= 0) {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + WEST);
                    } else {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + ", " + WEST);
                    }
                    retainedString += showCardinalPoints.getText().toString();
                    break;
                case R.id.north_button:
                    lastNrPressedCardinalButtons++;
                    if (showCardinalPoints.getText().toString().trim().length() <= 0) {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + NORTH);
                    } else {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + ", " + NORTH);
                    }
                    retainedString += showCardinalPoints.getText().toString();
                    break;
                case R.id.south_button:
                    lastNrPressedCardinalButtons++;
                    if (showCardinalPoints.getText().toString().trim().length() <= 0) {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + SOUTH);
                    } else {
                        showCardinalPoints.setText(showCardinalPoints.getText().toString() + ", " + SOUTH);
                    }
                    retainedString += showCardinalPoints.getText().toString();
                    break;
                case R.id.navigate_to_secondary_activity_button:
                    Intent myIntent = new Intent(getApplicationContext(), Colocviu1_13SecondaryActivity.class);
                    myIntent.putExtra(RETAINED_STRING, retainedString);
                    startActivityForResult(myIntent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    lastNrPressedCardinalButtons = 0;
                    break;
            }
            Toast.makeText(getApplicationContext(), lastNrPressedCardinalButtons + "Number of cardinal buttons pressed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13);

        showCardinalPoints = (EditText)findViewById(R.id.north_east_south_west);
        eastButton = (Button)findViewById(R.id.east_button);
        eastButton.setOnClickListener(buttonClickListener);
        westButton = (Button)findViewById(R.id.west_button);
        westButton.setOnClickListener(buttonClickListener);
        northButton = (Button)findViewById(R.id.north_button);
        northButton.setOnClickListener(buttonClickListener);
        southButton = (Button)findViewById(R.id.south_button);
        southButton.setOnClickListener(buttonClickListener);

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            lastNrPressedCardinalButtons = savedInstanceState.getInt(SAVED_NR_PRESSED_BUTTONS);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(SAVED_NR_PRESSED_BUTTONS, lastNrPressedCardinalButtons);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lastNrPressedCardinalButtons = savedInstanceState.getInt(SAVED_NR_PRESSED_BUTTONS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
    }
}
