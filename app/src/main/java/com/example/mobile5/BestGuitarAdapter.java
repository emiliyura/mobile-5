package com.example.mobile5;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BestGuitarAdapter extends RecyclerView.Adapter<BestGuitarAdapter.BestGuitarViewHolder> {

    private List<BestGuitar> bestGuitarList;

    public BestGuitarAdapter(List<BestGuitar> bestGuitarList) {
        this.bestGuitarList = bestGuitarList;
    }

    @NonNull
    @Override
    public BestGuitarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.best_guitar_item, parent, false);
        return new BestGuitarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestGuitarViewHolder holder, int position) {
        BestGuitar bestGuitar = bestGuitarList.get(position);
        holder.imageView.setImageResource(bestGuitar.getImageResource());
        holder.textView.setText(bestGuitar.getText());
    }

    @Override
    public int getItemCount() {
        return bestGuitarList.size();
    }

    public static class BestGuitarViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public BestGuitarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.best_guitar_image);
            textView = itemView.findViewById(R.id.best_guitar_name);
        }
    }
}

