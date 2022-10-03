package com.ciclo3.reto.appreto3.controlador;

import com.ciclo3.reto.appreto3.entidad.Car;
import com.ciclo3.reto.appreto3.servicio.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Car/") //Para mapear la clase
@CrossOrigin(origins = "*") //Este para q cualquier cliente pueda accerder a ella.
public class ApiCar {

    @Autowired
    private CarService service;

    @GetMapping("/all")
    public List<Car> findCarAll(){
        return service.getCar();
    }

    @PostMapping("/save")
    public ResponseEntity saveCar(@RequestBody Car car){
        service.saveCar(car);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity updateCar(@RequestBody Car car){
        service.updateCar(car);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity deleteCar(@PathVariable long id){
        service.deleteCar(id);
        return ResponseEntity.status(204).build();
    }
}
