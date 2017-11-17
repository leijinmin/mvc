/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Models.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;

/**
 *
 * @author JINMIN
 */
@Controller
@RequestMapping(value="/Cours")
public class CoursController {
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView liste() {
        return new ModelAndView("Listecours", "cours", DataContext.listeCours);
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String verifierNAS(HttpServletRequest request, ModelMap model){  
        model.addAttribute("message","Le NAS n'existe pas.");
        
        DataContext.listeEtudiant.stream()
                .filter(e -> e.getNas().equals(request.getParameter("nas")))
                .findFirst()
                .ifPresent( e -> {
                    new GestSession<Cours, Etudiant>(request, Vars.NAME_ID, Vars.NAME_LIST).ajouterId(e);
                    model.addAttribute("cours", DataContext.listeCours);
                    model.addAttribute("message","");
                }); 

        return "Listecours";
    }
    
    @RequestMapping(value="/{numero}/Ajouter",method=RequestMethod.GET)
    public String ajouter(HttpServletRequest request, @PathVariable int numero) {
        DataContext.listeCours.stream()
                .filter( c-> c.getNumero() == numero)
                .findFirst()
                .ifPresent( c -> {
                    new GestSession<Cours, Etudiant>(request,Vars.NAME_ID, Vars.NAME_LIST).ajouterDansListe(c);              
                });

          return "redirect:/Cours"; 
    }

}
