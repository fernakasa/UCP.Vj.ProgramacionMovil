package com.example.tp2_gametrivia.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp2_gametrivia.Entidades.Player;
import com.example.tp2_gametrivia.R;

public class EndGameActivity extends Activity {
    private TextView gameUser;
    private TextView gameScore;
    private Button newGame;
    private Button rankin;
    private Button exit;

    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        player = (Player) getIntent().getSerializableExtra("Player");

        gameUser = findViewById(R.id.endGameUser);
        gameScore = findViewById(R.id.endGameScore);
        newGame = findViewById(R.id.endGameNewGame);
        rankin = findViewById(R.id.endGameRanking);
        exit = findViewById(R.id.endGameExit);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndGameActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });

        rankin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndGameActivity.this, GameActivity.class);
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
            gameUser.setText(player.getUsername());
        }
    }

}
