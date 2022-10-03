package com.ciclo3.reto.appreto3.servicio;


import com.ciclo3.reto.appreto3.entidad.Client;
import com.ciclo3.reto.appreto3.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Este es una capa de mi servicio y va ser un intermediario entre repositorio
//Para q pueda hacer las operaciones basicas.
public class ClientService {
    @Autowired //Esta es la instancia el objeto se llama repository.
    private ClientRepository repository;

    public List<Client> getClients(){
        return repository.findAll(); //findAll devuelve todos los registro q tenga la tabla guardados
    }
    public Client saveClient(Client client){
        return repository.save(client);
    }
//Para buscar registro del cliente por su id. retorna cliente
    public Client getClien(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deleteClient(long id){
        repository.deleteById(id);
    }

                          //Cliente a actualizar
    public Client updateClient(Client clientUpd){

//Objeto q indica existencia de cliente...con este consulta si  existe
        Client clientOld = getClien(clientUpd.getIdClient());
//con este client viejo se va modificar.Actualizando name
        clientOld.setName(clientUpd.getName());
//Este modica, actualiza email.
         clientOld.setEmail(clientUpd.getEmail());
//Set le indica q va hacer una actualizacion no guarda.
         clientOld.setPassword(clientUpd.getPassword());
//Con este para actualizar edad
         clientOld.setAge(clientUpd.getAge());
                       //Save actualiza
         return repository.save(clientOld);

    }

}