package com.miprojet.web.controller;

import com.miprojet.web.exceptions.ImpossibleAjouterProjetException;
import com.miprojet.web.exceptions.ProjetNotFoundException;
import com.miprojet.dao.ProjetDao;
import com.miprojet.model.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjetController {
    @Autowired
    ProjetDao projetDao;

    // Affiche la liste de tous les projets disponibles
    @GetMapping(value = "/Projets")
    public List<Projet> listeDesProjets(){

        List<Projet> projets = projetDao.findAll();

        if(projets.isEmpty()) return null;//throw new ProjetNotFoundException("Aucun projet n'est disponible")

        return projets;

    }

    @GetMapping(value = "/Budgets")
    public Double budgetDesProjets(){

        if (projetDao.totalBudget() == null) {
            return 0.0;
        }
        return projetDao.totalBudget();

    }

    @GetMapping(value = "/ServiceBudgets")
    public List<List<Object>> budgetDesServices(){
        return projetDao.serviceBudget();
    }

    //Récuperer un projet par son id
    @GetMapping( value = "/Projets/{id}")
    public Optional<Projet> rechercherUneProjet(@PathVariable int id) {

        Optional<Projet> projet = projetDao.findById(id);

        if(!projet.isPresent())  return null;//throw new ProjetNotFoundException("Le projet correspondante au id " + projet + " n'existe pas")

        return projet;
    }


    //Récuperer projets par son idService
    @GetMapping( value = "/ProjetService/{idService}")
    public List<Projet> recupererProjetsService(@PathVariable int idService) {

        List<Projet> projets = projetDao.findAllByIdService(idService);

        if(projets.isEmpty())  return null;

        return projets;
    }

    @PostMapping(value = "/Projets")
    public Projet ajouterProjet(@RequestBody Projet projet){

        Projet nouveauProjet = projetDao.save(projet);

        if(nouveauProjet == null) throw new ImpossibleAjouterProjetException("Impossible d'ajouter ce projet");

        return nouveauProjet;
    }
}
