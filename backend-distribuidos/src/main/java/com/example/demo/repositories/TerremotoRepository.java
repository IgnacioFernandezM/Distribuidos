package com.example.demo.repositories;

import com.example.demo.models.Terremoto;

import java.util.List;

public interface TerremotoRepository {

    public List<Terremoto> getAllTerr();

    Terremoto getMaxProf();
    Terremoto getMinProf();
    float getAvgProf();
    Double getMedProf();

    Terremoto getMaxMag();
    Terremoto getMinMag();
    float getAvgMag();
    Double getMedMag();
}
