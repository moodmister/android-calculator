package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CanvasActivity extends AppCompatActivity {
    CanvasView canvasView;
    Intent thisIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        thisIntent = getIntent();
        int diameter = thisIntent.getIntExtra("diameter", 10);

        canvasView = new CanvasView(this);
        canvasView.diameter = diameter;
        setContentView(canvasView);
    }
}