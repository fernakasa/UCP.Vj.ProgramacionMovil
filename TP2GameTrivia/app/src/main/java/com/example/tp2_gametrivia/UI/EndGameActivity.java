package com.example.tp2_gametrivia.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp2_gametrivia.Database.AppDatabase;
import com.example.tp2_gametrivia.Entidades.Game;
import com.example.tp2_gametrivia.Entidades.Player;
import com.example.tp2_gametrivia.Interfaces.GameDao;
import com.example.tp2_gametrivia.R;

import androidx.room.Room;

public class EndGameActivity extends Activity {
    private TextView gameUser;
    private TextView gameScore;
    private Button newGame;
    private Button rankin;
    private Button exit;

    private Player player;
    private Game game;

    GameDao db;
    AppDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);

        player = (Player) getIntent().getSerializableExtra("Player");
        game = (Game) getIntent().getSerializableExtra("Game");

        dataBase = Room.databaseBuilder(this, AppDatabase.class, "trivia.db")
                .allowMainThreadQueries()
                .build();
        db = dataBase.gameDao();

        gameUser = findViewById(R.id.endGameUser);
        gameScore = findViewById(R.id.endGameScore);
        newGame = findViewById(R.id.endGameNewGame);
        rankin = findViewById(R.id.endGameRanking);
        exit = findViewById(R.id.endGameExit);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndGameActivity.this, GameActivity.class);
                intent.putExtra("Player", player);
                startActivity(intent);
                finish();
            }
        });

        rankin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndGameActivity.this, RankingActivity.class);
                intent.putExtra("Player", player);
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
            gameScore.setText(game.getScore() + " + " + (db.getScore(player.getPlayer_id()) - game.getScore()));
        }
    }

}
