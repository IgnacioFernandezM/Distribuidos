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
        try(Connection conn = sql2o.open()){
            String query = "SELECT  "+
                    "mag, place, " +
                    "ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof "+
                    "FROM terremoto";
            return conn.createQuery(query).executeAndFetch(Terremoto.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Terremoto getMaxProf() {
        try(Connection conn = sql2o.open()){
            String query = "SELECT  "+
                    "mag, place, " +
                    "ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof "+
                    "FROM terremoto " +
                    "WHERE ST_Z (ST_Transform (wkb_geometry, 4326)) = (" +
                    "   SELECT MAX (ST_Z (ST_Transform (wkb_geometry, 4326)))" +
                    "   FROM terremoto" +
                    ");";
            return conn.createQuery(query).executeAndFetchFirst(Terremoto.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Terremoto getMinProf() {
        try(Connection conn = sql2o.open()){
            String query = "SELECT  "+
                    "mag, place, " +
                    "ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof "+
                    "FROM terremoto " +
                    "WHERE ST_Z (ST_Transform (wkb_geometry, 4326)) = (" +
                    "   SELECT MIN (ST_Z (ST_Transform (wkb_geometry, 4326)))" +
                    "   FROM terremoto" +
                    ");";
            return conn.createQuery(query).executeAndFetchFirst(Terremoto.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public float getAvgProf() {
        try(Connection conn = sql2o.open()){
            String query = "select avg(ST_Z (ST_Transform (wkb_geometry, 4326))) from terremoto";
            return conn.createQuery(query).executeScalar(float.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public Double getMedProf() {
        try(Connection conn = sql2o.open()){
            String query = "SELECT  "+
                    "ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof "+
                    "FROM terremoto " +
                    "order by ST_Z (ST_Transform (wkb_geometry, 4326))";
            List<Double> terr;
            terr = conn.createQuery(query).executeAndFetch(Double.class);

            int largo = terr.size();
            int mitad = largo/2;
            if(largo%2==0){
                return (terr.get(mitad-1) + terr.get(mitad))/2;
            }
            return terr.get(mitad);

        }catch(Exception e) {
            return -1.0;
        }
    }

    @Override
    public Terremoto getMaxMag() {
        try(Connection conn = sql2o.open()){
            String query = "SELECT " +
                    "mag, place, " +
                    "ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof " +
                    "FROM terremoto " +
                    "WHERE mag = (" +
                    "   SELECT MAX (mag)" +
                    "   FROM terremoto" +
                    ");";
            return conn.createQuery(query).executeAndFetchFirst(Terremoto.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Terremoto getMinMag() {
        try(Connection conn = sql2o.open()){
            String query = "SELECT " +
                    "mag, place, " +
                    "ST_Z (ST_Transform (wkb_geometry, 4326)) AS prof " +
                    "FROM terremoto " +
                    "WHERE mag = (" +
                    "   SELECT MIN (mag)" +
                    "   FROM terremoto" +
                    ");";
            return conn.createQuery(query).executeAndFetchFirst(Terremoto.class);
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public float getAvgMag() {
        try(Connection conn = sql2o.open()){
            String query = "select avg(mag) from terremoto";
            return conn.createQuery(query).executeScalar(float.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public Double getMedMag() {
        try(Connection conn = sql2o.open()){
            String query = "SELECT  "+
                    "mag "+
                    "FROM terremoto " +
                    "order by mag";
            List<Double> terr;
            terr = conn.createQuery(query).executeAndFetch(Double.class);

            int largo = terr.size();
            int mitad = largo/2;
            if(largo%2==0){
                return (terr.get(mitad-1) + terr.get(mitad))/2;
            }
            return terr.get(mitad);

        }catch(Exception e) {
            return -1.0;
        }
    }
}
