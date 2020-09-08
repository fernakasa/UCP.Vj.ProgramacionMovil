package com.example.tp1;

import android.content.Intent;

public class SeriesData {
    private Integer serieImagen;
    private String serieNombre;
    private String serieAño;
    private String serieClasificacion;
    private String serieTemporadas;
    private String serieCategoria;
    private String serieResumen;

    public SeriesData(Integer serieImagen, String serieNombre, String serieAño, String serieClasificacion, String serieTemporadas, String serieCategoria, String serieResumen) {
        this.serieImagen = serieImagen;
        this.serieNombre = serieNombre;
        this.serieAño = serieAño;
        this.serieClasificacion = serieClasificacion;
        this.serieTemporadas = serieTemporadas;
        this.serieCategoria = serieCategoria;
        this.serieResumen = serieResumen;
    }

    public Integer getSerieImagen() {
        return serieImagen;
    }

    public void setSerieImagen(Integer serieImagen) {
        this.serieImagen = serieImagen;
    }

    public String getSerieNombre() {
        return serieNombre;
    }

    public void setSerieNombre(String serieNombre) {
        this.serieNombre = serieNombre;
    }

    public String getSerieAño() {
        return serieAño;
    }

    public void setSerieAño(String serieAño) {
        this.serieAño = serieAño;
    }

    public String getSerieClasificacion() {
        return serieClasificacion;
    }

    public void setSerieClasificacion(String serieClasificacion) {
        this.serieClasificacion = serieClasificacion;
    }

    public String getSerieTemporadas() {
        return serieTemporadas;
    }

    public void setSerieTemporadas(String serieTemporadas) {
        this.serieTemporadas = serieTemporadas;
    }

    public String getSerieCategoria() {
        return serieCategoria;
    }

    public void setSerieCategoria(String serieCategoria) {
        this.serieCategoria = serieCategoria;
    }

    public String getSerieResumen() {
        return serieResumen;
    }

    public void setSerieResumen(String serieResumen) {
        this.serieResumen = serieResumen;
    }


}
