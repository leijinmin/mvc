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
import java.util.*;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author JINMIN
 */
@Controller
@RequestMapping(value="/Panier")
public class PanierController {
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView afficher() {
        return new ModelAndView("AfficherPanier");
    }
    
    @RequestMapping(value="/Supprimer", method=RequestMethod.GET)
    public String supprimer(HttpServletRequest request,@RequestParam int[] numero) {
        Arrays.stream(numero).forEach( n -> {
            new GestSession(request,Vars.NAME_ID, Vars.NAME_LIST).supprimerDeListe( e -> ((Cours)e).getNumero() == Integer.valueOf(n));
        });
        return "redirect:/Panier";
    }
    
    @RequestMapping(value="/Valider", method=RequestMethod.GET)
    public String valider(HttpServletRequest request) {
        
        GestSession session = new GestSession(request,Vars.NAME_ID, Vars.NAME_LIST);
        
        String nas = ((Etudiant)session.getId()).getNas();
        
        List<Inscription> inscriptions = new ArrayList<>();
        
        ((List<Cours>)session.getListe()).stream().forEach( c -> 
                inscriptions.add(new Inscription(nas,c.getNumero(),Calendar.getInstance())));
        
        session.viderListe();
        
        return "redirect:/Index?length=" + inscriptions.size(); // Ajouter le paramêtre pour montrer que la liste d'inscription est remplie des données.
//        return "redirect:/Index?inscriptons=" + inscriptions.stream().map(i->i.toString()).collect(Collectors.joining(","));
    }
}
