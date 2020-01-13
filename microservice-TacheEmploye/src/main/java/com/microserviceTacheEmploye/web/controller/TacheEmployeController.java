package com.microserviceTacheEmploye.web.controller;

import com.microserviceTacheEmploye.dao.EmployeDao;
import com.microserviceTacheEmploye.dao.TacheDao;
import com.microserviceTacheEmploye.model.Employe;
import com.microserviceTacheEmploye.model.Tache;
import com.microserviceTacheEmploye.model.TacheEmploye;
import com.microserviceTacheEmploye.dao.TacheEmployeDao;
import com.microserviceTacheEmploye.model.TacheEmployeKey;
import com.microserviceTacheEmploye.web.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TacheEmployeController {
    @Autowired
    TacheEmployeDao tacheEmployeDao;

    @Autowired
    EmployeDao employeDao;

    @Autowired
    TacheDao tacheDao;

    // Affiche la liste de tous les taches pour employes
    @GetMapping(value = "/TachesEmployes")
    public List<TacheEmploye> listeDesTachesEmployes(){

        List<TacheEmploye> tachesEmployes = tacheEmployeDao.findAll();

        if(tachesEmployes.isEmpty()) return null;//throw new TacheEmployeNotFoundException("Tache / employe n'est pas disponible")

        return tachesEmployes;

    }

    @GetMapping(value = "/TachesEtat/{etat}")
    public List<TacheEmploye> listTachesEtat(@PathVariable String etat){

        return tacheEmployeDao.findAllByTache_Etat(etat);
    }

    //Récuperer un taches par son id

    @GetMapping( value = "/TachesEmployes/{idTache}/{idEmploye}")
    public Optional<TacheEmploye> rechercherUneTacheEmp(@PathVariable("idTache") int idTache,@PathVariable("idEmploye") int idEmploye) {

        Optional<TacheEmploye> tacheEmploye = tacheEmployeDao.findById_IdTacheAndId_IdEmploye(idTache,idEmploye);

        if(!tacheEmploye.isPresent()) throw new TacheEmployeNotFoundException("La tache correspondante au numero n'existe pas");

        return tacheEmploye;
    }

    @PostMapping(value = "/TachesEmployes")
    public TacheEmploye ajouterTacheParEmp(@RequestBody TacheEmploye tacheEmploye){
        TacheEmploye nouvelleTacheEmp = tacheEmployeDao.save(tacheEmploye);

        if(nouvelleTacheEmp == null) throw new ImpossibleAjouterTacheEmployeException("Impossible d'ajouter cette relation tach employe");

        return nouvelleTacheEmp;
    }

    @PutMapping(value = "/TachesEmployes")
    public TacheEmploye validerTacheEmploye(@RequestBody TacheEmploye tacheEmploye) {
            tacheEmployeDao.save(tacheEmploye);
            return tacheEmploye;
    }

    //Récuperer un tachesEmp par son idTache
    /*@GetMapping( value = "/TachesEmpls/{idTache}")
    public List<TacheEmploye> rechercherUneTacheEmpParIdTache(@PathVariable int idTache) {

        List<TacheEmploye> tacheEmployes = tacheEmployeDao.findAllByIdTache(idTache);

        if(tacheEmployes.isEmpty())  throw new TacheEmployeNotFoundException("La tache correspondante au numero " + idTache + " n'existe pas");

        return tacheEmployes;
    }*/


    //Emp controller

    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/Employes")
    public List<Employe> listeDesEmployes(){

        List<Employe> employes = employeDao.findAll();

        if(employes.isEmpty()) return null;//throw new EmployeNotFoundException("Aucun employe n'est disponible")

        return employes;

    }

    //Récuperer un produit par son id
    @GetMapping( value = "/Employes/{id}")
    public Optional<Employe> rechercherUnEmploye(@PathVariable int id) {

        Optional<Employe> employe = employeDao.findById(id);

        if(!employe.isPresent())  throw new EmployeNotFoundException("L'employe correspondant à l'id " + id + " n'existe pas");

        return employe;
    }

    @GetMapping( value = "/EmployesUsername/{username}")
    public Optional<Employe> rechercherEmployeByUsername(@PathVariable String username) {

        Optional<Employe> employe = employeDao.findByUsername(username);

        if(!employe.isPresent())  return null;

        return employe;
    }

    //Récuperer employes par son idService
    @GetMapping( value = "/EmployesService/{idService}")
    public List<Employe> recupererEmployesService(@PathVariable int idService) {

        List<Employe> employes = employeDao.findAllByIdService(idService);

        if(employes.isEmpty())  return null;

        return employes;
    }

    @PostMapping(value = "/Employes")
    public Employe ajouterEmploye(@RequestBody Employe employe){

        Employe nouveauEmploye = employeDao.save(employe);

        if(nouveauEmploye == null) throw new ImpossibleAjouterEmployeException("Impossible d'ajouter cet employe");

        return nouveauEmploye;
    }


    //tache controller

    // Affiche la liste de tous les taches disponibles
    @GetMapping(value = "/Taches")
    public List<Tache> listeDesTaches(){

        List<Tache> taches = tacheDao.findAll();

        if(taches.isEmpty()) return null;//throw new TacheNotFoundException("Aucun employe n'est disponible")

        return taches;

    }

    //Récuperer un taches par son id
    @GetMapping( value = "/Taches/{numero}")
    public Optional<Tache> rechercherUneTache(@PathVariable int numero) {

        Optional<Tache> tache = tacheDao.findById(numero);

        if(!tache.isPresent())  throw new TacheNotFoundException("La tache correspondante au numero " + numero + " n'existe pas");

        return tache;
    }

    //Récuperer un taches par son idProjet
    @GetMapping( value = "/TachesProjet/{idProjet}")
    public List<Tache> recupererTachesProjet(@PathVariable int idProjet) {

        List<Tache> taches = tacheDao.findAllByIdProjet(idProjet);

        if(taches.isEmpty())  return null;

        return taches;
    }

    @PostMapping(value = "/Taches")
    public Tache ajouterTache(@RequestBody Tache tache){

        Tache nouvelleTache = tacheDao.save(tache);

        if(nouvelleTache == null) throw new ImpossibleAjouterTacheException("Impossible d'ajouter cette tache");

        return nouvelleTache;
    }

    @GetMapping(value = "/TachesNonValide")
    public int tacheNonValide(){

        return tacheEmployeDao.countTacheEmployeByValideEquals("non");
    }

    @PutMapping(value = "/Taches")
    public Tache validerTache(@RequestBody Tache tache) {
        tacheDao.save(tache);
        return tache;
    }

    @GetMapping(value = "/TachesValide/{idProjet}")
    public Optional<Integer> tacheValide(@PathVariable int idProjet){

        return tacheDao.tacheValideByProjet("valide",idProjet);
    }

    @GetMapping(value = "/TachesByProjet")
    public List<Tache> listTachesByPrj(){

        return tacheDao.TachesByProjet();
    }
}
