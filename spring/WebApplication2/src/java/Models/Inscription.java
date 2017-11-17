/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Calendar;
import java.util.regex.Pattern;

/**
 *
 * @author JINMIN
 */
public class Inscription {
    private String nas;
    private int numeroCours;
    private Calendar calendar;

    public String getNas() {
        return nas;
    }

    public void setNas(String nas) {
        if(Pattern.matches("^\\d{9}$", nas))
            this.nas = nas;
        else throw new IllegalArgumentException("Le NAS est composé de 9 chiffres.");
    }

    public int getNumeroCours() {
        return numeroCours;
    }

    public void setNumeroCours(int numeroCours) {
        if( 0 < numeroCours )
            this.numeroCours = numeroCours;
        else
            throw new IllegalArgumentException("Non-valide numéro du cours.");
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Inscription(String nas, int numero, Calendar calendar) {
        this.setNas(nas);
        this.setNumeroCours(numero);
        this.setCalendar(calendar);
    }
    
    public String toString() {
        return String.format("nas:%s numero:%d calendar:%s", this.nas, this.numeroCours, this.calendar.getTime().toString());
    }
    
    
}
