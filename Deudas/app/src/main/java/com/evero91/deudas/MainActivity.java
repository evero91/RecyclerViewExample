package com.evero91.deudas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DeudasAdapter deudasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<String[]> deudas = new ArrayList<>();
        deudas.add(new String[]{"UNO", String.valueOf(R.drawable.uno)});
        deudas.add(new String[]{"DOS", String.valueOf(R.drawable.dos)});
        deudas.add(new String[]{"TRES", String.valueOf(R.drawable.tres)});

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        deudasAdapter = new DeudasAdapter(this, deudas);
        deudasAdapter.setListener(new DeudasAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.d("Deuda", String.valueOf(position) + " deuda " + deudas.get(position)[0]);
            }
        });
        deudasAdapter.setListenerImagen(new DeudasAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Log.d("Deuda", String.valueOf(position) + " imagen " + deudas.get(position)[1]);
            }
        });
        recyclerView.setAdapter(deudasAdapter);
    }
}