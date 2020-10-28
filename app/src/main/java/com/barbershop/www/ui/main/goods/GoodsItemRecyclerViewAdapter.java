package com.barbershop.www.ui.main.goods;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbershop.www.databinding.ItemLayoutBrandsBinding;
import com.barbershop.www.databinding.ItemLayoutItemsBinding;
import com.barbershop.www.model.Brand;
import com.barbershop.www.model.Item;

import java.util.ArrayList;
import java.util.List;


interface OnItemClickListener {
    void onItemClicked(Item item);
}

public class GoodsItemRecyclerViewAdapter extends RecyclerView.Adapter<GoodsItemRecyclerViewAdapter.ItemViewHolder> {
    private List<Item> itemList;
    private final OnItemClickListener onItemClickListener;

    GoodsItemRecyclerViewAdapter(OnItemClickListener onItemClickListener) {
        itemList = new ArrayList<>();
        this.onItemClickListener = onItemClickListener;
    }

    void submitList(List<Item> itemList) {
        if (this.itemList.size() != 0)
            this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(
                ItemLayoutItemsBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false)
                , onItemClickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutItemsBinding binding;
        private final OnItemClickListener onItemClickListener;

        public ItemViewHolder(ItemLayoutItemsBinding itemLayoutItemsBinding, OnItemClickListener onItemClickListener) {
            super(itemLayoutItemsBinding.getRoot());
            this.binding = itemLayoutItemsBinding;
            this.onItemClickListener = onItemClickListener;
        }

        public void bind(Item item) {
            binding.imageView.setImageResource(item.getImage());
            binding.textView2.setText(item.getName());
            binding.textView3.setText(item.getDesc());
            binding.getRoot().setOnClickListener(view -> {
                onItemClickListener.onItemClicked(item);
            });
        }

    }
}

