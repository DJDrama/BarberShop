package com.barbershop.www.ui.main.goods;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.barbershop.www.databinding.FragmentGoodsItemDetailBinding;
import com.barbershop.www.model.Brand;
import com.barbershop.www.model.Item;

public class GoodsItemDetailFragment extends Fragment {
    private FragmentGoodsItemDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGoodsItemDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Item item= (Item) getArguments().get("item");
        binding.imageView4.setImageResource(item.getImage());
        binding.tvTitle.setText(item.getName());
        binding.tvDesc.setText(item.getDesc());

        //rating bar
        binding.settingRatingBar.setRating(item.getSetting());
        binding.balimRatingBar.setRating(item.getBalim());
        binding.gojungRatingBar.setRating(item.getGojung());
        binding.shiningRatingBar.setRating(item.getShining());
    }
}
