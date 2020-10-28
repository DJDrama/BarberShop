package com.barbershop.www.ui.main.store;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbershop.www.databinding.ItemLayoutStoreBinding;
import com.barbershop.www.model.Store;

import java.util.ArrayList;
import java.util.List;

interface OnStoreClickListener {
    void onStoreClicked(Store store);
}

public class StoreRecyclerViewAdapter extends RecyclerView.Adapter<StoreRecyclerViewAdapter.StoreViewHolder> {
    private List<Store> storeList;
    private OnStoreClickListener onStoreClickListener;

    StoreRecyclerViewAdapter(OnStoreClickListener onStoreClickListener) {
        storeList = new ArrayList<>();
        this.onStoreClickListener = onStoreClickListener;
    }

    void submitList(List<Store> storeList) {
        if (this.storeList.size() != 0)
            this.storeList.clear();
        this.storeList.addAll(storeList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreViewHolder(ItemLayoutStoreBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), onStoreClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        Store store = storeList.get(position);
        holder.bind(store);
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    static class StoreViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutStoreBinding binding;
        private final OnStoreClickListener onStoreClickListener;

        public StoreViewHolder(ItemLayoutStoreBinding itemLayoutStoreBinding, OnStoreClickListener onStoreClickListener) {
            super(itemLayoutStoreBinding.getRoot());
            this.binding = itemLayoutStoreBinding;
            this.onStoreClickListener = onStoreClickListener;
        }

        public void bind(Store store) {
            binding.getRoot().setOnClickListener(view -> {
                onStoreClickListener.onStoreClicked(store);
            });
            binding.textView2.setText(store.getName());
            binding.textView3.setText(store.getAddress());
            binding.imageView.setImageResource(store.getImage());
        }
    }
}

