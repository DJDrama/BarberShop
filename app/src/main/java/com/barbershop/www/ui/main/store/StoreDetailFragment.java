package com.barbershop.www.ui.main.store;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.barbershop.www.databinding.FragmentStoreDetailBinding;
import com.barbershop.www.model.Store;
import com.google.android.libraries.maps.CameraUpdateFactory;
import com.google.android.libraries.maps.GoogleMap;
import com.google.android.libraries.maps.OnMapReadyCallback;
import com.google.android.libraries.maps.model.LatLng;
import com.google.android.libraries.maps.model.Marker;
import com.google.android.libraries.maps.model.MarkerOptions;

public class StoreDetailFragment extends Fragment implements OnMapReadyCallback {
    private FragmentStoreDetailBinding binding;
    private GoogleMap googleMap;

    private Store store;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentStoreDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        store = (Store) getArguments().get("store");
        binding.imageView4.setImageResource(store.getImage());
        binding.tvTitle.setText(store.getName());
        binding.tvAddress.setText(store.getAddress());
        binding.tvPhone.setText(store.getPhone());
        binding.tvPhone.setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + store.getPhone()));
            startActivity(intent);
        });

        binding.mapView.onCreate(savedInstanceState);
        binding.mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng latLng = new LatLng(store.getLatitude(), store.getLongitude());
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(false);

        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title(store.getName());
        Marker marker = googleMap.addMarker(markerOptions);
        marker.showInfoWindow();
    }
}
