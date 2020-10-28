package com.barbershop.www.ui.main.goods;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.barbershop.www.databinding.FragmentGoodsItemBinding;
import com.barbershop.www.model.Brand;
import com.barbershop.www.model.Item;
import java.util.List;

public class GoodsItemFragment extends Fragment implements OnItemClickListener {
    private FragmentGoodsItemBinding binding;
    private GoodsItemRecyclerViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentGoodsItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
        Brand brand= (Brand) getArguments().get("brand");
        adapter.submitList(brand.getItemList());

    }
    private void setRecyclerView() {
        adapter = new GoodsItemRecyclerViewAdapter(this);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClicked(Item item) {
        NavDirections action = GoodsItemFragmentDirections.actionGoodsItemFragmentToGoodsItemDetailFragment(item);
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }
}
