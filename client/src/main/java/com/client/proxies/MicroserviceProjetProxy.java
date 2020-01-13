package com.client.proxies;

import com.client.beans.ProjetBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "microservice-projet", url = "localhost:9004")
public interface MicroserviceProjetProxy {
    @GetMapping(value = "/Projets")
    List<ProjetBean> listeDesProjets();

    @GetMapping( value = "/Projets/{id}")
    ProjetBean rechercherUneProjet(@PathVariable("id") int id);

    @GetMapping( value = "/ProjetService/{idService}")
    List<ProjetBean> recupererProjetsService(@PathVariable int idService);

    @PostMapping(value = "/Projets")
    ProjetBean ajouterProjet(@RequestBody ProjetBean projet);

    @GetMapping(value = "/Budgets")
    Double budgetDesProjets();

    @GetMapping(value = "/ServiceBudgets")
    List<List<Object>> budgetDesServices();
}
