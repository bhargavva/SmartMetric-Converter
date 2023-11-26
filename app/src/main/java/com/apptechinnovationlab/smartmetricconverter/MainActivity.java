package com.apptechinnovationlab.smartmetricconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inchesEditText;
    private TextView metersTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setButtonClickListener();
    }

    private void setButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double meters = convertToMeters();
                displayResult(meters);
            }
        });
    }

    private void displayResult(double meters) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String metersText =  myDecimalFormatter.format(meters);
        metersTextView.setText(String.format("%s meters", metersText));
    }

    private double convertToMeters() {
        String inchesText = inchesEditText.getText().toString();
        int inches = Integer.parseInt(inchesText);
        return inches * 0.0254;
    }

    private void findViews(){
        inchesEditText = findViewById(R.id.edit_text_inches);
        metersTextView = findViewById(R.id.text_view_meters);
        calculateButton = findViewById(R.id.button_calculate);
    }

}