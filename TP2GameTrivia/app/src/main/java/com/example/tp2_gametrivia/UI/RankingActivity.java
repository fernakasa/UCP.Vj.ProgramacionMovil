package com.example.tp2_gametrivia.UI;

import android.content.Intent;
import android.os.Bundle;

import com.example.tp2_gametrivia.Adapter.RankingAdapter;
import com.example.tp2_gametrivia.Database.AppDatabase;
import com.example.tp2_gametrivia.Entidades.Game;
import com.example.tp2_gametrivia.Entidades.Player;
import com.example.tp2_gametrivia.Interfaces.GameDao;
import com.example.tp2_gametrivia.R;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class RankingActivity extends AppCompatActivity {
    private List<Game> games;
    GameDao db;
    AppDatabase dataBase;

    private Player player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        player = (Player) getIntent().getSerializableExtra("Player");

        dataBase = Room.databaseBuilder(this, AppDatabase.class, "trivia.db")
                .allowMainThreadQueries()
                .build();
        db = dataBase.gameDao();

        games = db.getPlayerScores(player.getPlayer_id());

        RecyclerView recyclerView = findViewById(R.id.rankingRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RankingAdapter adapter = new RankingAdapter();
        adapter.setGames(games);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RankingActivity.this, HomeActivity.class);
        intent.putExtra("Player", player);
        startActivity(intent);
        finish();
    }
}
