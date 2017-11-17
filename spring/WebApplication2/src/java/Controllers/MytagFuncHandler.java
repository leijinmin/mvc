/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Cours;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author JINMIN
 */
public class MytagFuncHandler {
    
    /**
     * 
     * @param numero Numero de cours
     * @param liste Liste de panier
     * @return Si le cours existe dans la liste de panier ou non
     */
    public static Boolean existe(int numero,List<Cours> liste) {
        return liste.stream().filter(c->c.getNumero() == numero).count()>0;
    }

    /**
     * Title on each page
     * @param request
     * @return Current page title
     */
    public static String getTitle(HttpServletRequest request) {
        String view = getViewName(request);
        switch(view) {
            case "Listecours"       : return "Liste des cours";
            case "AfficherPanier"   : return "Votre panier";
            case "SendEmail"        : return "Envoyer un message";           
        }
        return "";
    }
    /**
     * Each menu item has a status, selected or not
     * @param request
     * @return selection status of menu in the page
     * 
     */
    public static Hashtable getCss(HttpServletRequest request) {
        
        Hashtable<String,String> css = new Hashtable<String,String>() {{
            put("Accueil","");
            put("Listecours","");
            put("SendEmail","");
        }};
        
        String view = getViewName(request);
          
        css.keySet().stream().forEach( e-> {
            String val = "";
            if(e.equals(view)) val = "selected";             
            css.put(e, val);
        });

        return css;
    }
    
    private static String getViewName(HttpServletRequest request) {
        return Arrays.stream(request.getRequestURI().split("/")).filter(s -> s.endsWith(".jsp")).findFirst().get().replace(".jsp", "");
    }
    
}
