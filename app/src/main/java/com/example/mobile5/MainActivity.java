package com.example.mobile5;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView guitarCategoryListView;

    String[] guitarCategories = {"Ibanez", "ESP", "Fender", "Best Guitars", "ScrollActivity", "SpinnerActivity"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Находим представление списка
        guitarCategoryListView = findViewById(R.id.guitar_category_list);

        // Создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, guitarCategories);
        // Устанавливаем адаптер для списка
        guitarCategoryListView.setAdapter(adapter);

        // Создаем новый интент
        guitarCategoryListView.setOnItemClickListener((parent, view, position, id) -> {
            if (position < guitarCategories.length - 3) {
                Intent intent = new Intent(MainActivity.this, GuitarListActivity.class);
                intent.putExtra("category", guitarCategories[position]);
                startActivity(intent);
            } else if (position == guitarCategories.length - 2) {
                Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent);
            } else if (position == guitarCategories.length - 1) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(MainActivity.this, BestGuitarActivity.class);
                startActivity(intent);
            }
        });
    }
}
