package com.example.fartos.ActivitiesGame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fartos.Jugador;
import com.example.fartos.R;

import java.util.ArrayList;
import java.util.List;

public class SeleccionJugadores extends Activity {
    Button btnAddPlayer, btnRemovePlayer, btnStartGame;
    LinearLayout playersLayout;
    List<EditText> playerEditTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_jugadores);

        btnAddPlayer = findViewById(R.id.btn_add_player);
        btnRemovePlayer = findViewById(R.id.btn_remove_player);
        btnStartGame = findViewById(R.id.btn_start_game);
        playersLayout = findViewById(R.id.players_layout);
        playerEditTexts = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            addPlayerEditText();
        }

        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerEditTexts.size() < 6) {
                    addPlayerEditText();
                }
            }
        });

        btnRemovePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playerEditTexts.size() > 3) {
                    removePlayerEditText();
                }
            }
        });

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarPartida();
            }
        });
    }

    private void addPlayerEditText() {
        EditText editText = new EditText(this);
        editText.setHint("Mono " + (playerEditTexts.size() + 1));
        playerEditTexts.add(editText);
        playersLayout.addView(editText);
    }

    private void removePlayerEditText() {
        EditText editText = playerEditTexts.remove(playerEditTexts.size() - 1);
        playersLayout.removeView(editText);
    }

    private void iniciarPartida() {
        ArrayList<Jugador> jugadors = new ArrayList<>();
        for (EditText editText : playerEditTexts) {
            String name = editText.getText().toString().trim();
            if (!name.isEmpty()) {
                jugadors.add(new Jugador(name));
            }
        }

        if (jugadors.size() >= 3) {
            Intent intent = new Intent(this, Fartos2086.class);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("jugadors", jugadors);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Añada 3 nombres como mínimo para comenzar", Toast.LENGTH_SHORT).show();
        }
    }



}