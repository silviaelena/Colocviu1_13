package ro.pub.cs.systems.eim.colocviu1_13.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static ro.pub.cs.systems.eim.colocviu1_13.colocviu1_13.Constants.*;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {
    private EditText showText;
    private Button registerButton;
    private Button cancelButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.register_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_secondary);

        showText = (EditText)findViewById(R.id.show_text);
        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);

        showText.setText("");

        Intent myIntent = getIntent();
        if (myIntent != null && myIntent.getExtras().containsKey(RETAINED_STRING)) {
            showText.setText(myIntent.getStringExtra(RETAINED_STRING));
        }
    }
}
