package com.barbershop.www.ui.main.style;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbershop.www.databinding.ItemLayoutStyleBinding;
import com.barbershop.www.model.Style;

import java.util.ArrayList;
import java.util.List;

interface OnStyleClickListener{
    void onStyleClicked(Style style);
}
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.StyleViewHolder> {
    private List<Style> styleList;
    private OnStyleClickListener onStyleClickListener;

    RecyclerViewAdapter(OnStyleClickListener onStyleClickListener) {
        styleList = new ArrayList<>();
        this.onStyleClickListener = onStyleClickListener;
    }

    void submitList(List<Style> styleList) {
        if (this.styleList.size() != 0)
            this.styleList.clear();
        this.styleList.addAll(styleList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StyleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StyleViewHolder(ItemLayoutStyleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), onStyleClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StyleViewHolder holder, int position) {
        Style style = styleList.get(position);
        holder.bind(style);
    }

    @Override
    public int getItemCount() {
        return styleList.size();
    }

    static class StyleViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutStyleBinding binding;
        private final OnStyleClickListener onStyleClickListener;
        
        public StyleViewHolder(ItemLayoutStyleBinding itemLayoutStyleBinding, OnStyleClickListener onStyleClickListener) {
            super(itemLayoutStyleBinding.getRoot());
            this.binding = itemLayoutStyleBinding;
            this.onStyleClickListener = onStyleClickListener;
        }

        public void bind(Style style) {
            binding.getRoot().setOnClickListener(view -> {
                onStyleClickListener.onStyleClicked(style);
            });
            binding.textView2.setText(style.getTitle());
            binding.textView3.setText(style.getDescription());
            binding.imageView.setImageResource(style.getDrawableId().get(0));
        }
    }
}

