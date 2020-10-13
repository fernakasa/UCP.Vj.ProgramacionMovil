package com.example.tp2_gametrivia.Entidades;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game implements Serializable {

    //properties
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long game_id;
    private long player_id;
    private long score;
    private long lat;
    private long lon;

    public long getGame_id() {
        return game_id;
    }

    public void setGame_id(long game_id) {
        this.game_id = game_id;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public Game(long player_id, long score) {
        this.player_id = player_id;
        this.score = score;
    }

//    public Game(long player_id, long score, long lat, long lon) {
//        this.player_id = player_id;
//        this.score = score;
//        this.lat = lat;
//        this.lon = lon;
//    }
}
