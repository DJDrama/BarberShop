package com.barbershop.www.ui.main.style;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbershop.www.databinding.ItemLayoutBeardBinding;
import com.barbershop.www.databinding.ItemLayoutStyleBinding;
import com.barbershop.www.model.Style;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private final List<Integer> beardList;
    GridAdapter(){
        beardList = new ArrayList<>();
    }

    void submitList(List<Integer> beardList) {
        if (this.beardList.size() != 0)
            this.beardList.clear();
        this.beardList.addAll(beardList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridViewHolder(ItemLayoutBeardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        int imageResource = beardList.get(position);
        holder.bind(imageResource);
    }

    @Override
    public int getItemCount() {
        return beardList.size();
    }

    static class GridViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutBeardBinding binding;

        public GridViewHolder(ItemLayoutBeardBinding itemLayoutBeardBinding) {
            super(itemLayoutBeardBinding.getRoot());
            this.binding = itemLayoutBeardBinding;
        }

        public void bind(Integer src) {
            binding.imageBeard.setImageResource(src);
        }
    }
}

