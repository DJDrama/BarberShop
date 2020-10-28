package com.barbershop.www.ui.main.style;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.barbershop.www.databinding.FragmentStyleDetailBinding;
import com.barbershop.www.model.Style;

public class StyleDetailFragment extends Fragment {
    private FragmentStyleDetailBinding binding;
    private GridAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStyleDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
        Style style = (Style) getArguments().get("style");
        binding.imageView4.setImageResource(style.getDrawableId());
        binding.tvTitle.setText(style.getTitle());
        binding.tvDesc.setText(style.getDescription());
        adapter.submitList(style.getBeardList());
    }

    private void setRecyclerView(){
        adapter = new GridAdapter();
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
    }
}
