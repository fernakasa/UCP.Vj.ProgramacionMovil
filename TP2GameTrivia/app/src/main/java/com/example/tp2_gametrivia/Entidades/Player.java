package com.example.tp2_gametrivia.Entidades;

import java.io.Serializable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Player implements Serializable {

    //properties
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long player_id;
    private String username;
    private String password;

    public long getPlayer_id() { return player_id; }
    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) { this.password = password; }

    public Player(String username, String password){

        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
