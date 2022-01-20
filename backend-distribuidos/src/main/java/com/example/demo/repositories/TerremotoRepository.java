package com.example.demo.repositories;

import com.example.demo.models.Terremoto;

import java.util.List;

public interface TerremotoRepository {

    List<Terremoto> getAllTerr();

    Terremoto getMaxProf();
    Terremoto getMinProf();
    float getAvgProf();
    Terremoto getMedProf();

    Terremoto getMaxMag();
    Terremoto getMinMag();
    float getAvgMag();
    Terremoto getMedMag();
}
