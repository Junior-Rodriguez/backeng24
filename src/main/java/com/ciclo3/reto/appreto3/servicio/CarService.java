package com.ciclo3.reto.appreto3.servicio;

import com.ciclo3.reto.appreto3.entidad.Car;
import com.ciclo3.reto.appreto3.repositorio.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository repository;

//metodo Get,  algo repetitivo.
     public List<Car> getCar(){
         return repository.findAll();
     }
     public Car saveCar(Car car){

         return repository.save(car);
     }
     public Car getCar(long id){
         return repository.findById(id).orElse(null);
     }
     public Car updateCar(Car carUpd){
         Car carOld = getCar(carUpd.getId());
         carOld.setName(carUpd.getName());
         carOld.setBrand(carUpd.getBrand());
         carOld.setAño(carUpd.getAño());
         carOld.setDescription(carUpd.getDescription());
//Este es para actualizar la realacion forend.
         carOld.setGama(carUpd.getGama());
//Y como va a ver un cambio coneste lo va a salvar
         repository.save(carOld);
         return repository.save(carOld);
     }
     public void deleteCar(long id){
         repository.deleteById(id);
     }
  }
