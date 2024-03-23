package com.example.mobile5;
//o
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BestGuitarActivity extends AppCompatActivity {

    private RecyclerView bestGuitarRecyclerView;
    private BestGuitarAdapter bestGuitarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_guitar);

        bestGuitarRecyclerView = findViewById(R.id.best_guitar_recycler_view);
        bestGuitarRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bestGuitarAdapter = new BestGuitarAdapter(generateBestGuitarList());
        bestGuitarRecyclerView.setAdapter(bestGuitarAdapter);
    }

    private List<BestGuitar> generateBestGuitarList() {
        List<BestGuitar> bestGuitarList = new ArrayList<>();
        bestGuitarList.add(new BestGuitar(R.drawable.ibanez,"Ibanez Gio"));
        bestGuitarList.add(new BestGuitar(R.drawable.fender, "Fender Squier"));
        bestGuitarList.add(new BestGuitar(R.drawable.esp,"ESP Original"));

        return bestGuitarList;
    }
}
