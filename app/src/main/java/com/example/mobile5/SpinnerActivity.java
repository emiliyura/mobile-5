package com.example.mobile5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;

    String[] spinnerItems = {"apple", "banana", "orange", "grape", "pear", "peach", "watermelon", "pineapple", "mango", "kiwi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        // Находим представление списка
        spinner = findViewById(R.id.spinner);

        // Создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinnerItems);

        // Устанавливаем адаптер для списка nen
        spinner.setAdapter(adapter);
    }
}
