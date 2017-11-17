/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.*;
import java.util.function.Predicate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JINMIN
 */
public class GestSession <T,M> {
        private final HttpServletRequest request; 
        private String name;    // Nom de liste
        private String id;      // Nom d'identifiant
        private HttpSession session;
        
        /**
         * 
         * @param request HttpRequest
         * @param name Nom de liste
         * @param id Nom d'identifiant
         */
        public GestSession(HttpServletRequest request, String id, String name) 
        { 
            this.request = request; 
            this.id= id;
            this.name = name;
            this.session = request.getSession(true);
            
            if (this.session.getAttribute(this.name) == null){ 
                this.session.setAttribute(this.name,new ArrayList<T>()); 
            }           
        }
        /**
         * 
         * @param element L'élement à ajouter dans la liste
         */
        public void ajouterDansListe(T element) 
        { 
            List<T> liste = ((List<T>)request.getSession().getAttribute(this.name));
            liste.add(element); 
            this.session.setAttribute(this.name, liste);                
        } 
        /**
         * 
         * @param id  Nom d'identifiant  
         */
        public void ajouterId(M id) {
            this.session.setAttribute(this.id, id);
        }
        
        /**
         * 
         * @param match Lambda expression 
         */
        public void supprimerDeListe(Predicate<T> match) 
        {   
                List<T> liste = (List<T>)request.getSession().getAttribute(this.name); 
                liste.remove(liste.stream().filter(match).findFirst().get());
                this.session.setAttribute(this.name, liste);                
        } 
        
        /**
         * 
         * @return Retourner la liste
         */
        public List<T> getListe() {
            return (List<T>)this.session.getAttribute(this.name); 
        }
        
        /**
         * 
         * @return Retouner l'identifiant
         */
        public <M> M getId() {
            return (M)this.session.getAttribute(this.id);
        }
        /**
         * Vider la liste
         */
        public void viderListe() 
        { 
            List<T> liste = ((List<T>)this.session.getAttribute(this.name));
            liste.clear();
            this.session.setAttribute(this.name, liste);                
           // request.getSession().removeAttribute("panier"); 
        }
        
        /**
         * Vider l'identifiant et la liste
         */
        public void viderId() {
            this.session.setAttribute(this.name, null);
            this.session.setAttribute(this.id, null);
        }
                
}
