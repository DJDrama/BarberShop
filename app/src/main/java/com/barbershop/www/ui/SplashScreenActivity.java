package com.barbershop.www.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.barbershop.www.databinding.ActivitySplashScreenBinding;
import com.barbershop.www.ui.main.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide Actionbar
        getSupportActionBar().setShowHideAnimationEnabled(false);
        getSupportActionBar().hide();

        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Ken Burns Effect
        binding.backgroundImage.resume();

        //1.5 seconds
        int splashDisplayTime = 3000;
        new Handler().postDelayed((Runnable) this::navigateToMainActivity, splashDisplayTime);
    }
    private void navigateToMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}