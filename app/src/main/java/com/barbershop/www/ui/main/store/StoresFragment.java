package com.barbershop.www.ui.main.store;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.barbershop.www.R;
import com.barbershop.www.databinding.FragmentStoreBinding;
import com.barbershop.www.model.Store;
import com.barbershop.www.ui.main.style.StyleFragmentDirections;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class StoresFragment extends Fragment implements OnStoreClickListener {
    private FragmentStoreBinding binding;
    private List<Store> placeList = new ArrayList<>();
    private StoreRecyclerViewAdapter adapter;
    private FusedLocationProviderClient fusedLocationProviderClient;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStoreBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (checkIfAlreadyHavePermission())
            getMyLocation();
        else
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1111);

        setRecyclerView();
        //addPlaces();
    }

    private boolean checkIfAlreadyHavePermission() {
        int result = ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == 1111) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getMyLocation();
            } else {
                Toast.makeText(requireContext(), "Permission denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void getMyLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.getContext());
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(requireContext(), "Permission denied.", Toast.LENGTH_SHORT).show();
            return;
        }
        fusedLocationProviderClient
                .getLastLocation()
                .addOnSuccessListener(this::addPlaces);

    }

    private void addPlaces(Location location) {
        placeList.clear();
        placeList.add(new Store("필립 더 바버샵", "서울 송파구 송파대로 40길 1-32", 37.504280, 127.108716, R.drawable.philip, "02-424-9444"));
        placeList.add(new Store("마제스티 바버샵", "서울 송파구 올림픽로 300 롯데월드몰 3층", 37.514105, 127.104545, R.drawable.majesty, "02-3213-4358"));
        placeList.add(new Store("오클리먼33 바버샵", "서울 송파구 석촌호수로 230", 37.50741490, 127.10231833, R.drawable.oclian, "02-416-5550"));
        placeList.add(new Store("레드폴 바버샵", "서울 송파구 올림픽로 10길 35", 37.50855574, 127.08174473, R.drawable.redpole, "010-7930-9677"));
        placeList.add(new Store("바버샵 엉클부스", "서울 송파구 백제고분로7길 32-29", 37.50949549, 127.08290530, R.drawable.unclebooth, "010-5854-5828"));
        adapter.submitList(placeList, location);
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