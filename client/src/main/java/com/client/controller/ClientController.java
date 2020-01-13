package com.client.controller;

import com.client.beans.*;
import com.client.proxies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceServiceProxy serviceProxy;

    @Autowired
    private MicroserviceProjetProxy projetProxy;

    @Autowired
    private MicroserviceTacheEmployeProxy tacheEmployeProxy;

    @RequestMapping(value = "/form")
    public String form(){
        return "addform";
    }

    @RequestMapping(value = {"/","/index"})
    public String index(Model model){
        List<EmployeBean> employes = tacheEmployeProxy.listeDesEmployes();
        List<ServiceBean> services = serviceProxy.listeDesServicesActives();
        List<TacheBean> taches = tacheEmployeProxy.listTachesByPrj();
        List<TacheEmployeBean> tacheEmployes = tacheEmployeProxy.listeDesTachesEmployes();

        int tachesEmpNombre;
        int employeNombre;
        int servicesNombre;
        if (tacheEmployes == null){
            tachesEmpNombre = 0;
        }
        else {
            tachesEmpNombre = tacheEmployes.size();
        }

        if (employes == null){
            employeNombre = 0;
        }
        else {
            employeNombre = employes.size();
        }

        if (services == null){
            servicesNombre = 0;
        }
        else {
            servicesNombre = services.size();
        }

        int tachesNonValide = tacheEmployeProxy.tacheNonValide();
        double tachePourcent1 = ((double) tachesNonValide / tachesEmpNombre) * 100;
        int tachePourcent = (int) tachePourcent1;
        List<Fatia> fatias = new ArrayList<>();
        List<List<Object>> serviceBudgets = projetProxy.budgetDesServices();
        for(int i=0; i<serviceBudgets.size(); i++){
            Fatia fatia = new Fatia((double) serviceBudgets.get(i).get(1),"Service " + serviceProxy.rechercherUnService((int) serviceBudgets.get(i).get(0)).get().getLibelle_service());
            fatias.add(fatia);
        }


        List<ProjetPourcent> projectPourcents = new ArrayList<>();
        for (TacheBean tache : taches){
            int nbrTachesByPrj = tacheEmployeProxy.recupererTachesProjet(tache.getIdProjet()).size();
            int nbrTachesValideByPrj = nbrTachesByPrj - tacheEmployeProxy.tacheValide(tache.getIdProjet());
            double tacheValidePourcent1 = ((double) nbrTachesValideByPrj / nbrTachesByPrj) * 100;
            int tacheValidePourcent = (int) tacheValidePourcent1;
            projectPourcents.add(new ProjetPourcent(projetProxy.rechercherUneProjet(tache.getIdProjet()),tacheValidePourcent));
        }

        model.addAttribute("fatias",fatias);
        model.addAttribute("projectPourcents",projectPourcents);
        model.addAttribute("employesNombre",employeNombre);
        model.addAttribute("servicesNombre",servicesNombre);
        model.addAttribute("tachePourcent",tachePourcent);
        model.addAttribute("budget", projetProxy.budgetDesProjets());
        return "index";
    }

    @RequestMapping("/listeEmployes")
    public String listeEmployes(Model model){
        List<EmployeBean> employes = tacheEmployeProxy.listeDesEmployes();

        model.addAttribute("employes",employes);

        return "ListeEmployes";
    }

    @RequestMapping("/listeServices")
    public String listeDesServices(Model model){
        List<ServiceBean> services = serviceProxy.listeDesServices();

        model.addAttribute("services",services);

        return "ListeServices";
    }

    @RequestMapping("/listeTaches")
    public String listeTaches(Model model){
        List<TacheBean> taches = tacheEmployeProxy.listeDesTaches();

        model.addAttribute("taches",taches);

        return "ListeTaches";
    }

    @RequestMapping("/listeProjets")
    public String listeProjets(Model model){
        List<ProjetBean> projets = projetProxy.listeDesProjets();

        model.addAttribute("projets",projets);

        return "ListeProjets";
    }

    @RequestMapping("/listeTachesEmployes")
    public String listeTacheEmploye(Model model){
        List<TacheEmployeBean> tacheEmployes = tacheEmployeProxy.listeDesTachesEmployes();
        model.addAttribute("tacheEmployes",tacheEmployes);

        return "ListeTacheEmployes";
    }

    @RequestMapping("/listeTachesValidee")
    public String listeTacheEmpValidee(Model model){
        List<TacheEmployeBean> tacheEmployes = tacheEmployeProxy.listTachesEtat("valide");
        model.addAttribute("tacheEmployes",tacheEmployes);

        return "ListeTacheEmpValidee";
    }

    //Ajout tache
    @RequestMapping(value = "/addTache", method=RequestMethod.GET)
    public String showForm(Model model) {
        TacheBean tache = new TacheBean();
        List<ProjetBean> projets = projetProxy.listeDesProjets();
        tache.setContenu("");
        tache.setDate_finale_realisation(new Date());
        tache.setDuree(0);
        tache.setEtat("en cours");
        tache.setCommentaire("");

        model.addAttribute("projets",projets);
        model.addAttribute("tache", tache);
        return "addTache";
    }
    //Ajout tache
    @RequestMapping(value = "/ajouterTache", method=RequestMethod.POST)
    public String processForm(@ModelAttribute TacheBean tache,Model model) {
        TacheBean tacheAjoutee = tacheEmployeProxy.ajouterTache(tache);
        model.addAttribute("tacheAjoutee", tacheAjoutee);
        return "redirect:/addTacheEmploye/" + tacheAjoutee.getNumero();
    }

    //Ajout projet
    @RequestMapping(value = "/addProjet", method=RequestMethod.GET)
    public String showFormPrj(Model model) {
        ProjetBean projet = new ProjetBean();
        List<ServiceBean> services = serviceProxy.listeDesServices();
        projet.setNom("");
        projet.setDescription("");
        projet.setDate_debut(new Date());
        projet.setDate_fin(new Date());
        projet.setStatus_projet("debut");
        projet.setBudget(0);

        model.addAttribute("services",services);
        model.addAttribute("projet", projet);
        return "addProjet";
    }

    //Ajout projet
    @RequestMapping(value = "/ajouterProjet", method=RequestMethod.POST)
    public String processFormPrj(@ModelAttribute ProjetBean projet,Model model) {
        ProjetBean projetAjoutee = projetProxy.ajouterProjet(projet);
        model.addAttribute("projetAjoutee", projetAjoutee);
        return "redirect:/listeProjets";
    }

    //Ajout employe
    @RequestMapping(value = "/addEmploye", method=RequestMethod.GET)
    public String showFormEmp(Model model) {
        EmployeBean employe = new EmployeBean();
        List<ServiceBean> services = serviceProxy.listeDesServices();
        employe.setNom("");
        employe.setPrenom("");
        employe.setCivilite("");
        employe.setTele("");
        employe.setEmail("");
        employe.setStatus_employe("");
        employe.setDate_embauche(new Date());

        model.addAttribute("services",services);
        model.addAttribute("employe", employe);
        return "addEmploye";
    }

    //Ajout employe
    @RequestMapping(value = "/ajouterEmploye", method=RequestMethod.POST)
    public String processFormEmp(@ModelAttribute EmployeBean employe,Model model) {
        EmployeBean employeAjoutee = tacheEmployeProxy.ajouterEmploye(employe);
        model.addAttribute("employeAjoutee", employeAjoutee);
        return "redirect:/index";
    }

    //Ajout Service
    @RequestMapping(value = "/addService", method=RequestMethod.GET)
    public String showFormserv(Model model) {
        ServiceBean service = new ServiceBean();
        service.setLibelle_service("");
        service.setStatus_service("");

        model.addAttribute("service", service);
        return "addService";
    }

    //Ajout Service
    @RequestMapping(value = "/ajouterService", method=RequestMethod.POST)
    public String processFormServ(@ModelAttribute ServiceBean service,Model model) {
        ServiceBean serviceAjoutee = serviceProxy.ajouterService(service);
        model.addAttribute("serviceAjoutee", serviceAjoutee);
        return "redirect:/listeServices";
    }

    //Ajout Relation Tache employe
    @RequestMapping(value = "/addTacheEmploye/{idTache}", method=RequestMethod.GET)
    public String showFormTE(@PathVariable int idTache,Model model) {
        TacheEmployeBean tacheEmploye = new TacheEmployeBean();
        TacheBean tacheBean = tacheEmployeProxy.rechercherUneTache(idTache);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        Optional<EmployeBean> employe = tacheEmployeProxy.rechercherEmployeByUsername(username);

        tacheEmploye.setValide("non");
        tacheEmploye.setEtatChef("invalide");
        tacheEmploye.setTache(tacheBean);
        model.addAttribute("employe",employe);
        model.addAttribute("tacheEmploye", tacheEmploye);
        return "addTacheEmploye";
    }

    //Ajout Tache employe
    @RequestMapping(value = "/ajouterTacheEmploye", method=RequestMethod.POST)
    public String processFormTE(@ModelAttribute TacheEmployeBean tacheEmploye,Model model) {
        TacheEmployeBean tacheEmployeAjoutee = tacheEmployeProxy.ajouterTacheParEmp(tacheEmploye);
        model.addAttribute("tacheEmployeAjoutee", tacheEmployeAjoutee);
        return "redirect:/listeTachesEmployes";
    }

    //Valider tache

    @RequestMapping(value = "/edit/{idTache}/{idEmploye}")
    public String editTacheEmployeeById(Model model, @PathVariable("idTache") int idTache,@PathVariable("idEmploye") int idEmploye){
        Optional<TacheEmployeBean> tacheEmployeBean = tacheEmployeProxy.rechercherUneTacheEmp(idTache,idEmploye);
        TacheBean tacheBean = tacheEmployeProxy.rechercherUneTache(idTache);

        tacheBean.setEtat("valide");
        tacheEmployeBean.get().setValide("oui");
        tacheEmployeProxy.validerTacheEmploye(tacheEmployeBean.get());
        tacheEmployeProxy.validerTache(tacheBean);
        return "redirect:/listeTachesEmployes";
    }

    //Etat chef tache

    @RequestMapping(value = "/editEtatCHef/{idTache}/{idEmploye}")
    public String editTacheEmployeeEtatChef(Model model, @PathVariable("idTache") int idTache,@PathVariable("idEmploye") int idEmploye){
        Optional<TacheEmployeBean> tacheEmployeBean = tacheEmployeProxy.rechercherUneTacheEmp(idTache,idEmploye);
        TacheBean tacheBean = tacheEmployeProxy.rechercherUneTache(idTache);

        tacheEmployeBean.get().setEtatChef("accepte");
        tacheEmployeProxy.validerTacheEmploye(tacheEmployeBean.get());
        return "redirect:/listeTachesValidee";
    }

    @RequestMapping("/desactiverService")
    public String listeDesServicesDesactiver(Model model){
        List<ServiceBean> services = serviceProxy.listeDesServices();

        model.addAttribute("services",services);

        return "ListeServicesDesactive";
    }

    @RequestMapping(value = "/editService/{idService}")
    public String editServiceId(Model model, @PathVariable("idService") int idService){
        Optional<ServiceBean> serviceBean = serviceProxy.rechercherUnService(idService);

        serviceBean.get().setStatus_service("service off");
        serviceProxy.desactiverService(serviceBean.get());
        return "redirect:/desactiverService";
    }
}
