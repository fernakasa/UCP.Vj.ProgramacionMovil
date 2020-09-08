package com.example.tp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder>{
    SeriesData[] seriesData;
    Context context;

    public SeriesAdapter(SeriesData[] seriesData,MainActivity activity) {
        this.seriesData = seriesData;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.series_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SeriesData seriesDataList = seriesData[position];
        holder.imageViewSeries.setImageResource(seriesDataList.getSerieImagen());
        holder.textViewTitulo.setText(seriesDataList.getSerieNombre());
        holder.textViewAnio.setText(seriesDataList.getSerieAño());
        holder.textViewClasificacion.setText(seriesDataList.getSerieClasificacion());
        holder.textViewTemporada.setText(seriesDataList.getSerieTemporadas());
        holder.textViewGenero.setText(seriesDataList.getSerieCategoria());
        holder.textViewResumen.setText(seriesDataList.getSerieResumen());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context, seriesDataList.getSerieNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return seriesData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageViewSeries;
        TextView textViewTitulo;
        TextView textViewAnio;
        TextView textViewClasificacion;
        TextView textViewTemporada;
        TextView textViewGenero;
        TextView textViewResumen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewSeries = itemView.findViewById(R.id.imageView);
            textViewTitulo = itemView.findViewById(R.id.titulo);
            textViewAnio = itemView.findViewById(R.id.año);
            textViewClasificacion = itemView.findViewById(R.id.clasificacion);
            textViewTemporada = itemView.findViewById(R.id.temporada);
            textViewGenero = itemView.findViewById(R.id.genero);
            textViewResumen = itemView.findViewById(R.id.resumen);

        }
    }
}
