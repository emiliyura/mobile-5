package com.example.mobile5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GuitarAdapter extends RecyclerView.Adapter<GuitarAdapter.GuitarViewHolder> {

    private Context context;
    private List<Guitar> guitars;

    public GuitarAdapter(Context context, List<Guitar> guitars) {
        this.context = context;
        this.guitars = guitars;
    }

    @NonNull
    @Override
    public GuitarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new GuitarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuitarViewHolder holder, int position) {
        Guitar guitar = guitars.get(position);
        holder.guitarName.setText(guitar.getBrand() + " " + guitar.getModel());
    }

    @Override
    public int getItemCount() {
        return guitars.size();
    }

    public class GuitarViewHolder extends RecyclerView.ViewHolder {

        public TextView guitarName;

        public GuitarViewHolder(@NonNull View itemView) {
            super(itemView);
            guitarName = itemView.findViewById(android.R.id.text1);
        }
    }
}
