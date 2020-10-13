package com.example.tp2_gametrivia.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tp2_gametrivia.Entidades.Game;
import com.example.tp2_gametrivia.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingHolder> {
    private List<Game> games = new ArrayList<>();






    @NonNull
    @Override
    public RankingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ranking_cardview, parent, false);
        return new RankingHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingHolder holder, int position) {
        Game currentGame = games.get(position);
        holder.rankingName.setText(String.valueOf(currentGame.getPlayer_id()));
        holder.rankingScore.setText(String.valueOf(currentGame.getScore()));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public void setGames(List<Game> games) {
        this.games = games;
        notifyDataSetChanged();
    }

    class RankingHolder extends RecyclerView.ViewHolder{
        private TextView rankingName;
        private TextView rankingScore;

        public RankingHolder(@NonNull View itemView) {
            super(itemView);
            rankingName = itemView.findViewById(R.id.rankingName);
            rankingScore = itemView.findViewById(R.id.rankingScore);
        }
    }
}
