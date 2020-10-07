package com.example.tp2_gametrivia.UI;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tp2_gametrivia.Entidades.Player;
import com.example.tp2_gametrivia.R;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUser;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        player = (Player) getIntent().getSerializableExtra("User");

        tvUser = findViewById(R.id.tvUser);

        if (player != null) {
            tvUser.setText("Bienvenido " + player.getUsername());
        }
    }
}