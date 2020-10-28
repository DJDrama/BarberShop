package com.barbershop.www.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barbershop.www.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.clPomadeStyle.setOnClickListener(this);
        binding.pomadeGoods.setOnClickListener(this);
        binding.pomadeStores.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.clPomadeStyle) {
            navigateToActivity(StyleActivity.class);
        } else if (view == binding.pomadeGoods) {
            navigateToActivity(GoodsActivity.class);
        } else {
            navigateToActivity(StoresActivity.class);
        }
    }

    private void navigateToActivity(Class className) {
        Intent intent = new Intent(this, className);
        startActivity(intent);
    }
}
