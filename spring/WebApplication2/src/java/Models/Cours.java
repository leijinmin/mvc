/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author JINMIN
 */
public class Cours {
    private int numero, nombreCredits, session;
    private String Intitule, nomFicher;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if( 0 < numero )
            this.numero = numero;
        else
            throw new IllegalArgumentException("Non-valide numero de cours.");
    }

    public int getNombreCredits() {
        return nombreCredits;
    }

    public void setNombreCredits(int nombreCredits) {
        if( 0 < nombreCredits )
            this.nombreCredits = nombreCredits;
        else
            throw new IllegalArgumentException("Non-valide nombre de crédits.");
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public String getIntitule() {
        return Intitule;
    }

    public void setIntitule(String Intitule) {
        this.Intitule = Intitule;
    }

    public String getNomFicher() {
        return nomFicher;
    }

    public void setNomFicher(String nomFicher) {
        this.nomFicher = nomFicher;
    }
    
    public Cours(int Numero, int nombreCredits, int session, String Intitule, String nomFicher) {
        this.setNumero(Numero);
        this.setNombreCredits(nombreCredits);
        this.setSession(session);
        this.setIntitule(Intitule);
        this.setNomFicher(nomFicher);
    }    
}
