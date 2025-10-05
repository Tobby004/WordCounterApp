package com.example.wordcounterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerChoice;
    private Button btnCount;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerChoice = findViewById(R.id.spinnerChoice);
        btnCount = findViewById(R.id.btnCount);
        tvResult = findViewById(R.id.tvResult);

        // Load spinner options from strings.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.metrics_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChoice.setAdapter(adapter);

        // Handle button click
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextInput.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, getString(R.string.toast_empty), Toast.LENGTH_SHORT).show();
                    return;
                }

                int choice = spinnerChoice.getSelectedItemPosition();
                int result = 0;

                switch (choice) {
                    case 0: // Sentences
                        result = TextMetrics.countSentences(input);
                        break;
                    case 1: // Words
                        result = TextMetrics.countWords(input);
                        break;
                    case 2: // Characters
                        result = TextMetrics.countChars(input);
                        break;
                    case 3: // Numbers
                        result = TextMetrics.countNumbers(input);
                        break;
                }

                tvResult.setText(getString(R.string.result_label) + result);
            }
        });
    }
}
