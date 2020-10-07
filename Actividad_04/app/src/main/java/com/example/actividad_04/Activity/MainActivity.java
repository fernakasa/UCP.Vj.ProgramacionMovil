package com.example.actividad_04.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;

import com.example.actividad_04.AppDatabase;
import com.example.actividad_04.Entity.GameEntity;
import com.example.actividad_04.Entity.GameEntityRegionEntityCrossRef;
import com.example.actividad_04.Entity.RegionEntity;
import com.example.actividad_04.Entity.SaleEntity;
import com.example.actividad_04.R;
import com.example.actividad_04.Result.GameWithRegions;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dataBaseInit();

    }

    private void dataBaseInit(){
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "gameDB").allowMainThreadQueries().build();

        // Insert regions
        RegionEntity region1 = new RegionEntity();
        region1.RegionId = 1;
        region1.Name = "South America";

        RegionEntity region2 = new RegionEntity();
        region2.RegionId = 2;
        region2.Name = "North America";

        // Final Insert in Table Region
        db.regionDao().insert(region1, region2);

        //Insert games
        GameEntity g1 = new GameEntity();
        g1.GameId = 1;
        g1.Name = "Clash of Clans";
        g1.Stock = 10;

        GameEntity g2 = new GameEntity();
        g2.GameId = 2;
        g2.Name = "Angry Birds";
        g2.Stock = 20;

        GameEntity g3 = new GameEntity();
        g3.GameId = 3;
        g3.Name = "Free Fire";
        g3.Stock = 50;

        GameEntity g4 = new GameEntity();
        g4.GameId = 4;
        g4.Name = "Candy Crush";
        g4.Stock = 5;

        GameEntity g5 = new GameEntity();
        g5.GameId = 5;
        g5.Name = "Fortnite";
        g5.Stock = 25;

        GameEntity g6 = new GameEntity();
        g6.GameId = 6;
        g6.Name = "Minecraft";
        g6.Stock = 1;

        // Final Insert in Table Game
        db.gameDao().insert(g1,g2,g3,g4,g5,g6);

        //Insert GameRegion
        GameEntityRegionEntityCrossRef gr11 = new GameEntityRegionEntityCrossRef();
        gr11.GameId = 1;
        gr11.RegionId = 1;
        gr11.Price = 10;

        GameEntityRegionEntityCrossRef gr12 = new GameEntityRegionEntityCrossRef();
        gr12.GameId = 1;
        gr12.RegionId = 2;
        gr12.Price = 10;

        GameEntityRegionEntityCrossRef gr21 = new GameEntityRegionEntityCrossRef();
        gr21.GameId = 2;
        gr21.RegionId = 1;
        gr21.Price = 10;

        GameEntityRegionEntityCrossRef gr32 = new GameEntityRegionEntityCrossRef();
        gr32.GameId = 3;
        gr32.RegionId = 2;
        gr32.Price = 10;
        GameEntityRegionEntityCrossRef gr42 = new GameEntityRegionEntityCrossRef();
        gr42.GameId = 4;
        gr42.RegionId = 2;
        gr42.Price = 10;

        GameEntityRegionEntityCrossRef gr51 = new GameEntityRegionEntityCrossRef();
        gr51.GameId = 5;
        gr51.RegionId = 1;
        gr51.Price = 10;

        GameEntityRegionEntityCrossRef gr52 = new GameEntityRegionEntityCrossRef();
        gr52.GameId = 5;
        gr52.RegionId = 2;
        gr52.Price = 5;

        // Final Insert in Table GameRegion
        db.gameRegionDao().insert(gr11,gr12,gr21,gr32,gr42,gr51,gr52);

        //Insert sales

        SaleEntity s1 = new SaleEntity();
        s1.SaleId =1;
        s1.CustomerName = "Fernando";
        s1.GameId = 2;

        SaleEntity s2 = new SaleEntity();
        s2.SaleId =2;
        s2.CustomerName = "Nicollas";
        s2.GameId = 4;

        db.saleDao().insert(s1,s2);
    }

    public void testDB(View view) {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"gameDB").allowMainThreadQueries().build();
                //databaseBuilder(getApplicationContext(),AppDatabase.class,"gameDB").allowMainThreadQueries().build();
        List<GameWithRegions> gameWithRegions = db.gameDao().getGameWithRegions();

        gameWithRegions.size();
    }
}