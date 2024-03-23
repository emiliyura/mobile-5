package com.example.mobile5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GuitarListActivity extends AppCompatActivity {

    private ListView guitarListView;
    private ArrayAdapter<Guitar> guitarAdapter;
    private List<Guitar> guitars;
    private List<Guitar> selectedGuitars;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guitar_list);

        guitarListView = findViewById(R.id.guitar_list_view);

        String category = getIntent().getStringExtra("category");
        guitars = new ArrayList<>();

        if (category.equals("Ibanez")) {
            guitars.add(new Guitar("Ibanez", "RG"));
            guitars.add(new Guitar("Ibanez", "S"));
            guitars.add(new Guitar("Ibanez", "AZ"));
            guitars.add(new Guitar("Ibanez", "FR"));
            guitars.add(new Guitar("Ibanez", "AR"));
            guitars.add(new Guitar("Ibanez", "Prestige"));
        } else if (category.equals("ESP")) {
            guitars.add(new Guitar("ESP", "Original"));
            guitars.add(new Guitar("ESP", "USA"));
            guitars.add(new Guitar("ESP", "LTD"));
            guitars.add(new Guitar("ESP", "E-II"));
            guitars.add(new Guitar("ESP", "Custom Shop"));
            guitars.add(new Guitar("ESP", "Signature"));
        } else if (category.equals("Fender")) {
            guitars.add(new Guitar("Mercedes", "Jazzmaster"));
            guitars.add(new Guitar("Mercedes", "Jaguar"));
            guitars.add(new Guitar("Mercedes", "Mustang"));
            guitars.add(new Guitar("Mercedes", "Coronado"));
            guitars.add(new Guitar("Mercedes", "Performer"));
            guitars.add(new Guitar("Mercedes", "Bass V"));
        }

        selectedGuitars = new ArrayList<>();

        guitarAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                guitars);
        guitarListView.setAdapter(guitarAdapter);

        guitarListView.setOnItemClickListener((parent, view, position, id) -> {
            Guitar selectedGuitar = (Guitar) parent.getItemAtPosition(position);
            if (guitarListView.isItemChecked(position)) {
                selectedGuitars.add(selectedGuitar);
            } else {
                selectedGuitars.remove(selectedGuitar);
            }
        });

        Button addButton = findViewById(R.id.add_button);
        Button removeButton = findViewById(R.id.remove_button);
        EditText guitarBrandModelEditText = findViewById(R.id.guitar_brand_model);

        addButton.setOnClickListener(v -> {
            String input = guitarBrandModelEditText.getText().toString().trim();
            if (!input.isEmpty()) {
                String[] parts = input.split(" ");
                if (parts.length >= 2) {
                    Guitar newGuitar = new Guitar(parts[0], input.substring(parts[0].length() + 1));
                    guitars.add(newGuitar);
                    guitarAdapter.notifyDataSetChanged();
                    guitarBrandModelEditText.setText("");
                }
            }
        });

        removeButton.setOnClickListener(v -> {
            for (int i = 0; i < selectedGuitars.size(); i++) {
                guitars.remove(selectedGuitars.get(i));
            }
            selectedGuitars.clear();
            guitarAdapter.notifyDataSetChanged();
            guitarListView.clearChoices();
        });
    }
}
