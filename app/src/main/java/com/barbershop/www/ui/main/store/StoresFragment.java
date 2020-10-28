package com.barbershop.www.ui.main.store;

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

import com.barbershop.www.R;
import com.barbershop.www.databinding.FragmentStoreBinding;
import com.barbershop.www.model.Store;
import com.barbershop.www.ui.main.style.StyleFragmentDirections;

import java.util.ArrayList;
import java.util.List;

public class StoresFragment extends Fragment implements OnStoreClickListener {
    private FragmentStoreBinding binding;
    private List<Store> placeList = new ArrayList<>();
    private StoreRecyclerViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStoreBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
        addPlaces();

    }
    private void addPlaces(){
        placeList.clear();
        placeList.add(new Store("필립 더 바버샵", "서울 송파구 송파대로 40길 1-32", 37.504280, 127.108716, R.drawable.philip,  "02-424-9444"));
        placeList.add(new Store("마제스티 바버샵", "서울 송파구 올림픽로 300 롯데월드몰 3층", 37.514105, 127.104545, R.drawable.majesty,  "02-3213-4358"));
        placeList.add(new Store("오클리먼33 바버샵", "서울 송파구 석촌호수로 230", 37.50741490, 127.10231833, R.drawable.oclian,  "02-416-5550"));
        placeList.add(new Store("레드폴 바버샵", "서울 송파구 올림픽로 10길 35", 37.50855574, 127.08174473, R.drawable.redpole,  "010-7930-9677"));
        placeList.add(new Store("바버샵 엉클부스", "서울 송파구 백제고분로7길 32-29", 37.50949549, 127.08290530, R.drawable.unclebooth,  "010-5854-5828"));
        adapter.submitList(placeList);
    }

    private void setRecyclerView() {
        adapter = new StoreRecyclerViewAdapter(this);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStoreClicked(Store store) {
        NavDirections action = StoresFragmentDirections.actionStoresFragmentToStoreDetailFragment(store);
        Navigation.findNavController(binding.getRoot()).navigate(action);
    }
}