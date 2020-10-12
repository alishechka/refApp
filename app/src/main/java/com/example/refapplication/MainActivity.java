package com.example.refapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity {
    private TextView hello;
    private PoetryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);

        viewModel = new ViewModelProvider(this).get(PoetryViewModel.class);

        viewModel.getPoemData();
        viewModel.poem().observe(this, randomPoem -> {
            hello.setText(randomPoem.getAuthor());
        });
        viewModel.error().observe(this, error -> {
            hello.setText(error);
        });
    }
}