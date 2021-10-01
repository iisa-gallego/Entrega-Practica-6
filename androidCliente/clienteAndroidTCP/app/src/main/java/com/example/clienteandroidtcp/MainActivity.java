package com.example.clienteandroidtcp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button up, down, left, right, color;
    private usuarioTCP conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up = findViewById(R.id.upBtn);
        down = findViewById(R.id.downBtn);
        left = findViewById(R.id.leftBtn);
        right = findViewById(R.id.rightBtn);
        color = findViewById(R.id.colorBtn);

        conexion = new usuarioTCP();
        conexion.start();

        up.setOnClickListener(
                (v) -> {
                    conexion.escribir("arriba");
                }
        );
        down.setOnClickListener(
                (v) -> {
                    conexion.escribir("abajo");
                }
        );
        left.setOnClickListener(
                (v) -> {
                    conexion.escribir("izquierda");
                }
        );
        right.setOnClickListener(
                (v) -> {
                   conexion.escribir("derecha");
                }
        );

        color.setOnClickListener(
                (v) -> {
                    conexion.escribir("color");
                }
        );

    }
}
