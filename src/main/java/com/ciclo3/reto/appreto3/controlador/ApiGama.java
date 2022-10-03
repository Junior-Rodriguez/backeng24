package com.ciclo3.reto.appreto3.controlador;


import com.ciclo3.reto.appreto3.entidad.Gama;
import com.ciclo3.reto.appreto3.servicio.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gama/") //Para mapear la clase
@CrossOrigin(origins = "*") //Este para q cualquier cliente pueda accerder a ella.

public class ApiGama {

    @Autowired //Instancia de GamaService con operaciones CRUD
    private GamaService service;

    @GetMapping("/all")
    public List<Gama> findAllGama(){
        return service.getGama();
    }
    @GetMapping("/id")
    public Gama getGama(@PathVariable long id){
        return service.getGama(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveGama(@RequestBody Gama gama){
        service.saveGama(gama);
        return ResponseEntity.status(201).build();

    }
    @PutMapping("/update")
    public ResponseEntity updateGama(@RequestBody Gama gama){
        service.updateGama(gama);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGama(@PathVariable long id){
        service.deleteGama(id);
        return ResponseEntity.status(204).build();
    }

}
