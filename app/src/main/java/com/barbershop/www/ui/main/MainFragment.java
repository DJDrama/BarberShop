package com.barbershop.www.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.barbershop.www.R;
import com.barbershop.www.databinding.FragmentMainBinding;


public class MainFragment extends Fragment implements View.OnClickListener {
    private FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.clPomadeStyle.setOnClickListener(this);
        binding.pomadeGoods.setOnClickListener(this);
        binding.pomadeStores.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.clPomadeStyle) {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment2_to_styleFragment);
        } else if (view == binding.pomadeGoods) {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment2_to_goodsFragment);
        } else {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment2_to_storesFragment);
        }
    }
}
