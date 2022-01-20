package com.example.demo.services;

import com.example.demo.models.Terremoto;
import com.example.demo.repositories.TerremotoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/terremotos")
public class TerremotoService {

    private final TerremotoRepository terremotoRepository;
    TerremotoService(TerremotoRepository terremotoRepository){
        this.terremotoRepository = terremotoRepository;
    }

    //GETS -----------------------------------------------------------------------------------------------
    @GetMapping("/getAll")
    public List<Terremoto> getAllTerr(){
       return terremotoRepository.getAllTerr();
    }
    @GetMapping("/getMaxProf")
    public Terremoto getMaxProf(){
        return terremotoRepository.getMaxProf();
    }
    @GetMapping("/getMinProf")
    public Terremoto getMinProf(){
        return terremotoRepository.getMinProf();
    }
    @GetMapping("/getAvgProf")
    public float getAvgProf(){
        return terremotoRepository.getAvgProf();
    }
    @GetMapping("/getMedProf")
    public Double getMedProf(){
        return terremotoRepository.getMedProf();
    }

    @GetMapping("/getMaxMag")
    public Terremoto getMaxMag(){
        return terremotoRepository.getMaxMag();
    }
    @GetMapping("/getMinMag")
    public Terremoto getMinMag(){
        return terremotoRepository.getMinMag();
    }
    @GetMapping("/getAvgMag")
    public float getAvgMag(){
        return terremotoRepository.getAvgMag();
    }
    @GetMapping("/getMedMag")
    public Double getMedMag(){
        return terremotoRepository.getMedMag();
    }
}

