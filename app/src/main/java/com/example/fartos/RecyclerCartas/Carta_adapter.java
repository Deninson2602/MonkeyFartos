package com.example.fartos.RecyclerCartas;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartos.R;


public class Carta_adapter extends RecyclerView.ViewHolder {

    private TextView carta;
    Carta_adapter(@NonNull View itemView) {
        super(itemView);
        carta = itemView.findViewById(R.id.carta);
    }

    public TextView getCarta() {

        return carta;

    }
}


