package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SeriesAdapter seriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        SeriesData[] mySeriesData = new SeriesData[]{
                new SeriesData(R.drawable.thealist,"The A List","2018","7+","1 Temporada","Suspenso","En este drama intrigante y sobrenatural, el romance, la rivalidad y el misterio extremo chocan cuando un grupo de adolescentes va de campamento a una isla remota."),
                new SeriesData(R.drawable.defenders,"Defenders","2017","16+","Miniserie","Suspenso","Una conspiración siniestra amenaza Nueva York, y Daredevil, Jessica Jones, Luke Cage y Iron Fist unen sus fuerzas para enfrentar a sus enemigos en común."),
                new SeriesData(R.drawable.houseofcards,"House of Cards","2018","16+","6 Temporadas","Siniestro","Frank ya no está, y Claire Underwood pisa fuerte como la primera mujer presidenta de Estados&nbsp;Unidos. Aunque a algunos no les guste."),
                new SeriesData(R.drawable.insatiable,"Insatiable","2019","16+","2 Temporadas","Politicamente Incorrecto","Mientras la policía investiga el asesinato, Patty se esfuerza por unir a las concursantes en una campaña de relaciones públicas para cambiar el enfoque de las noticias."),
                new SeriesData(R.drawable.narcos,"Narcos","2017","16+","3 Temporadas","Suspenso","La verdadera historia de los poderosos y violentos cárteles de droga colombianos es el marco de esta serie dramática sobre el narco."),
                new SeriesData(R.drawable.strangerthings,"Stranger Things","2019","16+","3 Temporadas","Suspenso","Will es testigo de algo horroroso cuando regresa a casa. Cerca de ahí, un laboratorio gubernamental esconde un terrible secreto en sus profundidades."),
                new SeriesData(R.drawable.the100,"The 100","2019","16+","6 Temporadas","Suspenso","Raven descubre qué está causando la interferencia. Clarke y Finn se muestran más agresivos, mientras los traidores tienen en la mira al presidente Wallace."),
                new SeriesData(R.drawable.theendofthefuckingworld,"The end of the F***ing World","2019","16+","2 Temporadas","Siniestro","Matar animales ya no lo motiva. Con diecisiete añitos, James ahora planea su primer asesinato real, pero justo aparece Alyssa para desconcentrarlo."),
                new SeriesData(R.drawable.thesociety,"The Society","2019","16+","1 Temporada","Siniestro","Los habitantes del acaudalado pueblo de West Ham desaparecen misteriosamente. Solo se salvan los adolescentes, que deben crear su propia sociedad para sobrevivir."),
                new SeriesData(R.drawable.thewitcher,"The Witcher","2019","16+","1 Temporada","Suspenso","Un hombre misterioso quiere sumar a Geralt a la cacería de un dragón terrible, y la aventura trae una cara conocida. Ciri sospecha de su entorno y hace preguntas.")
        };

        seriesAdapter = new SeriesAdapter(mySeriesData,MainActivity.this);
        recyclerView.setAdapter(seriesAdapter);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                seriesAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}