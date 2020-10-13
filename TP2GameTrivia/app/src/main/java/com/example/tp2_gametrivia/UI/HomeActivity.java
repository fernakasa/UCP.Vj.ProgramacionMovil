package com.example.tp2_gametrivia.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tp2_gametrivia.Entidades.Player;
import com.example.tp2_gametrivia.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private TextView gameUser;
    private Button newGame;
    private Button rankin;
    private Button exit;

    private JSONArray trivia;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        player = (Player) getIntent().getSerializableExtra("Player");

        gameUser = findViewById(R.id.homeUsername);
        newGame = findViewById(R.id.homeNewGame);
        rankin = findViewById(R.id.homeRanking);
        exit = findViewById(R.id.homeExit);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, GameActivity.class);
                intent.putExtra("Player", player);
                intent.putExtra("Trivia", (Parcelable) trivia);
                startActivity(intent);
                finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (player != null) {
            gameUser.setText("Bienvenido " + player.getUsername());
        }

    }

}