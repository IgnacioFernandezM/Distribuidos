package com.example.demo.repositories;

import com.example.demo.models.Terremoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TerremotoRepositoryImp implements TerremotoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Terremoto> getAllTerr(){
        return null;
    }

    @Override
    public Terremoto getMaxProf() {
        try(Connection conn = sql2o.open()){
            String query = "SELECT" +
                    "ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof," +
                    "mag, place" +
                    "FROM data2" +
                    "WHERE mag = (" +
                    "   SELECT MAX (mag)" +
                    "   FROM data2" +
                    ");";
            String query2 = "SELECT \n" +
                    "       ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof,\n" +
                    "       mag, place\n" +
                    "FROM data2\n" +
                    "WHERE mag = (\n" +
                    "   SELECT MAX (mag)\n" +
                    "   FROM data2\n" +
                    ");";
            return conn.createQuery(query2).executeAndFetch(Terremoto.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Terremoto getMinProf() {
        return null;
    }

    @Override
    public float getAvgProf() {
        try(Connection conn = sql2o.open()){
            String query;
            return
        }
    }

    @Override
    public Terremoto getMedProf() {
        return null;
    }

    @Override
    public Terremoto getMaxMag() {
        return null;
    }

    @Override
    public Terremoto getMinMag() {
        return null;
    }

    @Override
    public float getAvgMag() {
        return 0;
    }

    @Override
    public Terremoto getMedMag() {
        return null;
    }
}
