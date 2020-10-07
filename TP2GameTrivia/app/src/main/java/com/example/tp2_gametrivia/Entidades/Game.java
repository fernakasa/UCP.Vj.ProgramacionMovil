package com.example.tp2_gametrivia.Entidades;

import android.provider.BaseColumns;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Game.TABLE_NAME)
public class Game {

    //names for tables
    public static final String TABLE_NAME = "game";
    public static final String COLUMN_ID = BaseColumns._ID;

    //properties
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = COLUMN_ID)
    public long game_id;

    @ColumnInfo(name = "player_id")
    private long player_id;

    @ColumnInfo(name = "score")
    private long score;

    @ColumnInfo(name = "lat")
    private long lat;

    @ColumnInfo(name = "lon")
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

    public Game(long game_id, long player_id, long score, long lat, long lon) {
        this.game_id = game_id;
        this.player_id = player_id;
        this.score = score;
        this.lat = lat;
        this.lon = lon;
    }
}
