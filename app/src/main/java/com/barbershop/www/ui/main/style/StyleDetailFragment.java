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

public class StyleDetailFragment extends Fragment implements OnPhotoClickListener {
    private FragmentStyleDetailBinding binding;
    private GridAdapter adapter;
    private HorizontalRecyclerviewAdapter horizontalRecyclerviewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStyleDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTopRecyclerview();
        setBottomRecyclerview();

        Style style = (Style) getArguments().get("style");
        binding.imageView4.setImageResource(style.getDrawableId().get(0));
        binding.tvTitle.setText(style.getTitle());
        binding.tvDesc.setText(style.getDescription());

        horizontalRecyclerviewAdapter.submitList(style.getDrawableId());
        adapter.submitList(style.getBeardList());

    }
    private void setTopRecyclerview(){
        horizontalRecyclerviewAdapter = new HorizontalRecyclerviewAdapter(this);
        binding.horizontalRecyclerview.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.horizontalRecyclerview.setLayoutManager(layoutManager);
        binding.horizontalRecyclerview.setAdapter(horizontalRecyclerviewAdapter);
    }
    private void setBottomRecyclerview(){
        adapter = new GridAdapter();
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPhotoClicked(int drawable) {
        binding.imageView4.setImageResource(drawable);
    }
}
