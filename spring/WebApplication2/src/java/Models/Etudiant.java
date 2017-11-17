/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.regex.*;

/**
 *
 * @author JINMIN
 */
public class Etudiant {
    private String nas, nom, prenom, telephone, adresse, codePostal,courriel;
    private char sexe ;   

    public Etudiant(String nas, String nom, String prenom, String telephone, String adresse, String codePostal, String courriel, char sexe) {
        this.setNas(nas);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setTelephone(telephone);
        this.setAdresse(adresse);
        this.setCodePostal(codePostal);
        this.setCourriel(courriel);
        this.setSexe(sexe);
        
    }    
    public String getNas() {
        return nas;
    }

    public void setNas(String nas) {
        if(Pattern.matches("^\\d{9}$", nas))
            this.nas = nas;
        else throw new IllegalArgumentException("Le NAS est composé de 9 chiffres.");
    }

    public String getNom() {
        return capitalizeFirstLetter(nom);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return capitalizeFirstLetter(prenom);
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if(Pattern.matches("^\\d{3}-\\d{3}-\\d{4}$", telephone))
            this.telephone = telephone;
        else throw new IllegalArgumentException("Téléphone doit respecter le format ###-###-####");
    }

    public String getAdresse() {
        return capitalizeFirstLetter(adresse);
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal.toUpperCase();
    }

    public void setCodePostal(String codePostal) {
        if(Pattern.matches("^[a-zA-Z0-9]{6}$", codePostal))
            this.codePostal = codePostal;
        else 
            throw new IllegalArgumentException("Le code postal n'est pas valide.");
    }

    public String getCourriel() {
        return this.courriel;
    }

    public void setCourriel(String courriel) {
        if(Pattern.matches("^[a-zA-Z]+[\\w-]*@\\w+\\.[a-zA-Z]+$", courriel))
            this.courriel = courriel;
        else 
            throw new IllegalArgumentException("Le courriel n'est pas valide.");
    }
    
    public char getSexe(char sexe) {
        return this.sexe;
    }
    
    public void setSexe(char sexe) {
        char sexe2 = Character.toUpperCase(sexe);
        if( sexe2 == 'F' || sexe2 == 'M')
            this.sexe = sexe2;
        else 
            throw new IllegalArgumentException("Le sexe doît être 'F' ou 'M'.");  
    }
    
    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
