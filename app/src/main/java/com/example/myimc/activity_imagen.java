package com.example.myimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class activity_imagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        ImageView imagenDelgado = findViewById(R.id.imageView);
        imagenDelgado.setImageResource(R.drawable.delgado);

        imagenDelgado.setVisibility(View.VISIBLE); // Estado general
        imagenDelgado.setVisibility(View.INVISIBLE); // Esta pero no se vel
        imagenDelgado.setVisibility(View.GONE); // se elimina del XML

    }
}
