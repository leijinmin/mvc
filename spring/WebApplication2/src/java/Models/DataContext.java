/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.*;

/**
 *
 * @author JINMIN
 */
public class DataContext {
    public static List<Cours> listeCours = new ArrayList<Cours>(){
        {{
            add(new Cours(1, 5, 1, "AngularJS", "AngularJS"));
            add(new Cours(2, 5, 1, "JQuery", "JQuery"));
            add(new Cours(3, 5, 1, "TypeScript", "TypeScript"));
            add(new Cours(4, 5, 1, "NodeJS", "NodeJS"));
         }}
    };
    public static List<Etudiant> listeEtudiant = new ArrayList<Etudiant>() {
        {{
            add(new Etudiant("123456789", "Lei", "Jinmin", "816-111-1111", "Boulvard des Grives", "J9A010", "leijinmin@gmail.com",'F'));
            add(new Etudiant("023456789", "Warren", "Buffett", "816-111-1111", "Boulvard des Grives", "J9A010", "leijinmin@gmail.com",'F'));
            add(new Etudiant("123456788", "Gates", "Bill", "816-111-1111", "Boulvard des Grives", "J9A010", "leijinmin@gmail.com",'F'));
        }}
    };
    public static List<Inscription> listeInscription = new ArrayList<Inscription>();
    
    public static void AjouterInscription(Inscription inscription) throws Throwable {
        DataContext.listeInscription
                .add(DataContext.listeInscription
                .stream()
                .filter( i -> {return i.getNas().equals(inscription.getNas());})
                .findFirst()
                .orElseThrow(()-> new Exception("Ce cours n'existe pas.")));
    }
}
