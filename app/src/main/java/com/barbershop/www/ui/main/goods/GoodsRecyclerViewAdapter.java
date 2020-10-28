package com.barbershop.www.ui.main.goods;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.barbershop.www.databinding.ItemLayoutBrandsBinding;
import com.barbershop.www.model.Brand;

import java.util.ArrayList;
import java.util.List;


interface OnGoodClickedListener {
    void onGoodClicked(Brand brand);
}

public class GoodsRecyclerViewAdapter extends RecyclerView.Adapter<GoodsRecyclerViewAdapter.GoodsViewHolder> {
    private List<Brand> brandList;
    private final OnGoodClickedListener onGoodClickedListener;


    GoodsRecyclerViewAdapter(OnGoodClickedListener onGoodClickedListener) {
        brandList = new ArrayList<>();
        this.onGoodClickedListener = onGoodClickedListener;
    }

    void submitList(List<Brand> brandList) {
        if (this.brandList.size() != 0)
            this.brandList.clear();
        this.brandList.addAll(brandList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GoodsRecyclerViewAdapter.GoodsViewHolder(
                ItemLayoutBrandsBinding.inflate(
                        LayoutInflater.from(parent.getContext()), parent, false)
                , onGoodClickedListener);

    }

    @Override
    public void onBindViewHolder(@NonNull GoodsViewHolder holder, int position) {
        Brand brand = brandList.get(position);
        holder.bind(brand);
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }

    static class GoodsViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutBrandsBinding binding;
        private final OnGoodClickedListener onGoodClickedListener;

        public GoodsViewHolder(ItemLayoutBrandsBinding itemLayoutBrandsBinding, OnGoodClickedListener onGoodClickedListener) {
            super(itemLayoutBrandsBinding.getRoot());
            this.binding = itemLayoutBrandsBinding;
            this.onGoodClickedListener = onGoodClickedListener;
        }

        public void bind(Brand brand) {
            binding.tvType.setText(brand.getType() == 0 ? "수성" : "유성");
            binding.imageView.setImageResource(brand.getImage());
            binding.textView2.setText(brand.getName());
            binding.textView3.setText(brand.getDesc());
            binding.getRoot().setOnClickListener(view -> {
                onGoodClickedListener.onGoodClicked(brand);
            });
        }

    }
}

