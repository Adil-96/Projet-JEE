package com.client.proxies;

import com.client.beans.ServiceBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "microservice-service", url = "localhost:9003")
public interface MicroserviceServiceProxy {

    @GetMapping(value = "/Services")
    List<ServiceBean> listeDesServices();

    @GetMapping( value = "/Services/{id}")
    Optional<ServiceBean> rechercherUnService(@PathVariable("id") int id);

    @PostMapping(value = "/Services")
    ServiceBean ajouterService(@RequestBody ServiceBean service);

    @PutMapping(value = "/Services")
    ServiceBean desactiverService(@RequestBody ServiceBean service);

    @GetMapping(value = "/ServicesActives")
    List<ServiceBean> listeDesServicesActives();
}
