package com.example.fartos.RecyclerCartas;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartos.R;

import java.util.ArrayList;
import java.util.List;

public class Cartas_recycler extends RecyclerView.Adapter<Carta_adapter> {

    private List<Carta> cartas;

    public Cartas_recycler(List<Carta> films) {
        this.cartas = films;
    }

    public List<Carta> get() {
        return cartas;
    }

    public void flush(){
        this.cartas = new ArrayList<>();
    }

    public void add(Object grupo) {
        this.cartas.add((Carta) grupo);
        this.notifyItemInserted(this.cartas.size() - 1);
    }

    public void add(List<Carta> grupo) {
        this.cartas = grupo;
        this.notifyItemInserted(this.cartas.size() - 1);
    }


    @NonNull
    @Override
    public Carta_adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_carta, parent, false);
        final Carta_adapter viewHolder = new Carta_adapter(vista);
        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull Carta_adapter holder, @SuppressLint("RecyclerView") int position) {
        Carta carta = this.cartas.get(position);
        holder.getCarta().setText(carta.getEfecte().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.getPosition(position);


            }
        });

    }

    @Override
    public int getItemCount() {
        return this.cartas.size();
    }

    OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public interface OnItemClick {
        void getPosition(int pos);
    }
}
