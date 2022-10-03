package com.ciclo3.reto.appreto3.servicio;

import com.ciclo3.reto.appreto3.entidad.Gama;
import com.ciclo3.reto.appreto3.repositorio.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Este va a probeer un servicio de intermediario entre la base de datos y la Api.
public class GamaService {

    @Autowired//Esta es la instancia de repositorio se llama para hacer operaciones CRUD
    private GamaRepository repository;

//Metodo para mostrar datos Get.
    public List<Gama> getGama(){
        return repository.findAll();

    }
    public Gama getGama(long id){
        return repository.findById(id).orElse(null);
    }
//Metodo para Guardar ca gama, Datos con save.
    public Gama saveGama(Gama gama){
        return repository.save(gama);
    }
    public Gama updateGama(Gama gamaupd){
        Gama gamaOld = getGama(gamaupd.getId());
        gamaOld.setName(gamaupd.getName());
        gamaOld.setDescription(gamaupd.getDescription());
        return repository.save(gamaOld);
    }

//Metodo para borrar
    public void deleteGama(long id){
        repository.deleteById(id);
    }
}
