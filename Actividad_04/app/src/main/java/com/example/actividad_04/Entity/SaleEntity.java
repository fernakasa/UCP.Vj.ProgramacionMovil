package com.example.actividad_04.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sale")
public class SaleEntity {

    @PrimaryKey
    public int SaleId;

    public String CustomerName;

    public int GameId;

}
