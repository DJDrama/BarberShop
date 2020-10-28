package com.barbershop.www.ui.main.style;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.barbershop.www.R;
import com.barbershop.www.databinding.FragmentStyleBinding;
import com.barbershop.www.model.Style;

import java.util.ArrayList;
import java.util.List;

public class StyleFragment extends Fragment implements OnStyleClickListener {
    private List<Style> styleList = new ArrayList();
    private FragmentStyleBinding binding;
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStyleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
        addItems();
    }

    private void addItems() {
        styleList.clear();
        styleList.add(new Style("Man Bun", "전체적으로 윗머리를 길러서 뒤로 묵어 주는 스타일", R.drawable.manbun,
                new ArrayList() {{
                    add(R.drawable.balbo);
                    add(R.drawable.chincurtain);
                }}));
        styleList.add(new Style("Quiff", "옆머리는 완전 붙이고 앞머리를 풍성하게 볼륨감을 주는 스타일", R.drawable.quiff,
                new ArrayList() {{
                    add(R.drawable.hungarian);
                    add(R.drawable.shaftbeard);
                    add(R.drawable.classicfullbeard);
                }}));
        styleList.add(new Style("Side Swept", "윗머리를 길게 길러서 한쪽으로 쓸어 넘기고 고정시키는 스타일", R.drawable.sideswept,
                new ArrayList() {{
                        add(R.drawable.balbo);
                        add(R.drawable.shaftbeard);
                    }}));
        styleList.add(new Style("Slick Back", "윗머리를 전체적으로 뒤로 쓸어 넘겨서 고정 시키는 스타일", R.drawable.slickback,
                new ArrayList() {{
                    add(R.drawable.classicfullbeard);
                }}));
        styleList.add(new Style("Swept Back", "Swept Back Description Needed", R.drawable.sweptback,
                new ArrayList() {{
                    add(R.drawable.classicfullbeard);
                    add(R.drawable.chincurtain);
                }}));

        adapter.submitList(styleList);
    }

    private void setRecyclerView() {
        adapter = new RecyclerViewAdapter(this);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStyleClicked(Style style) {
        NavDirections action = StyleFragmentDirections.actionStyleFragmentToStyleDetailFragment(style);
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }
}