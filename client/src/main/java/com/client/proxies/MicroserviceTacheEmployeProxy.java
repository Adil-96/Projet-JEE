package com.client.proxies;

import com.client.beans.EmployeBean;
import com.client.beans.TacheBean;
import com.client.beans.TacheEmployeBean;
import com.client.beans.TacheEmployeKeyBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "microservice-TacheEmploye", url = "localhost:9005")
public interface MicroserviceTacheEmployeProxy {
    @GetMapping(value = "/TachesEmployes")
    List<TacheEmployeBean> listeDesTachesEmployes();

    @PostMapping(value = "/TachesEmployes")
    TacheEmployeBean ajouterTacheParEmp(@RequestBody TacheEmployeBean tacheEmploye);

    @PutMapping(value = "/TachesEmployes")
    TacheEmployeBean validerTacheEmploye(@RequestBody TacheEmployeBean tacheEmploye);

    @GetMapping( value = "/TachesEmployes/{idTache}/{idEmploye}")
    Optional<TacheEmployeBean> rechercherUneTacheEmp(@PathVariable("idTache") int idTache,@PathVariable("idEmploye") int idEmploye);

    @GetMapping(value = "/TachesEtat/{etat}")
    List<TacheEmployeBean> listTachesEtat(@PathVariable String etat);

    //emp proxy

    @GetMapping(value = "/Employes")
    List<EmployeBean> listeDesEmployes();

    @GetMapping( value = "/Employes/{id}")
    EmployeBean rechercherUnEmploye(@PathVariable("id") int id);

    @GetMapping( value = "/EmployesService/{idService}")
    List<EmployeBean> recupererEmployesService(@PathVariable int idService);

    @PostMapping(value = "/Employes")
    EmployeBean ajouterEmploye(@RequestBody EmployeBean employe);

    @GetMapping( value = "/EmployesUsername/{username}")
    Optional<EmployeBean> rechercherEmployeByUsername(@PathVariable String username);

    //tache proxy

    @GetMapping(value = "/Taches")
    List<TacheBean> listeDesTaches();

    @GetMapping( value = "/Taches/{numero}")
    TacheBean rechercherUneTache(@PathVariable("numero") int numero);

    @GetMapping( value = "/TachesProjet/{idProjet}")
    List<TacheBean> recupererTachesProjet(@PathVariable("idProjet") int idProjet);

    @PostMapping(value = "/Taches")
    TacheBean ajouterTache(@RequestBody TacheBean tache);

    @GetMapping(value = "/TachesNonValide")
    int tacheNonValide();

    @PutMapping(value = "/Taches")
    TacheBean validerTache(@RequestBody TacheBean tache);

    @GetMapping(value = "/TachesValide/{idProjet}")
    int tacheValide(@PathVariable int idProjet);

    @GetMapping(value = "/TachesByProjet")
    List<TacheBean> listTachesByPrj();
}
