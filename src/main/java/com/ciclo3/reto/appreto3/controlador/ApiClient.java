package com.ciclo3.reto.appreto3.controlador;


import com.ciclo3.reto.appreto3.entidad.Client;
import com.ciclo3.reto.appreto3.servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client/")
@CrossOrigin(origins = "*")//Para q pueda ser consumida por cualquier cliente
public class ApiClient {
    @Autowired//La instancia, osea creando el objeto de esta clase. Injec de indepen
    private ClientService service; //Instancia
    @GetMapping("/all")
    public List<Client> findAllClients(){
        return service.getClients();

    }
//Peticion Get con el parametro id q retorna a cliente
    @GetMapping("/{id}")
    public Client getClient(@PathVariable long id){
        return service.getClien(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody Client client){
        service.saveClient(client);
        return ResponseEntity.status(201).build();
    }
    @PutMapping("/update")
    public ResponseEntity editClient(@RequestBody Client client){
        service.updateClient(client);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleClient(@PathVariable long id){
        service.deleteClient(id);
        return ResponseEntity.status(204).build();
    }

}
