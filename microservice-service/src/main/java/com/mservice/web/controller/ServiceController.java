package com.mservice.web.controller;

import com.mservice.dao.ServiceDao;
import com.mservice.model.Service;
import com.mservice.web.exceptions.ImpossibleAjouterServiceException;
import com.mservice.web.exceptions.ServiceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceController {
    @Autowired
    ServiceDao serviceDao;

    // Affiche la liste de tous les services disponibles
    @GetMapping(value = "/Services")
    public List<Service> listeDesServices(){

        List<Service> services = serviceDao.findAll();

        if(services.isEmpty()) return null;//throw new ServiceNotFoundException("Aucun service n'est disponible")

        return services;

    }

    //Récuperer un Service par son id
    @GetMapping( value = "/Services/{id}")
    public Optional<Service> rechercherUnService(@PathVariable int id) {

        Optional<Service> service = serviceDao.findById(id);

        if(!service.isPresent())  throw new ServiceNotFoundException("Le service correspondant à l'id " + id + " n'existe pas");

        return service;
    }

    @PostMapping(value = "/Services")
    public Service ajouterService(@RequestBody Service service){

        Service nouveauService = serviceDao.save(service);

        if(nouveauService == null) throw new ImpossibleAjouterServiceException("Impossible d'ajouter ce service");

        return nouveauService;
    }

    @PutMapping(value = "/Services")
    public Service desactiverService(@RequestBody Service service) {
        serviceDao.save(service);
        return service;
    }

    @GetMapping(value = "/ServicesActives")
    public List<Service> listeDesServicesActives(){

        List<Service> services = serviceDao.rechercherAllByStatus("service on");

        if(services.isEmpty()) return null;//throw new ServiceNotFoundException("Aucun service n'est disponible")

        return services;

    }
}
