package com.bets.testnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.bets.testnotification.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());


    }
}