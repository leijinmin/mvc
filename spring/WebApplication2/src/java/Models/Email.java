/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author JINMIN
 */
public class Email {
    private String from, to, subject;
    private String message;

    public Email() {
        
    }
    public Email(String from, String to, String subject, String message) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }
    @ModelAttribute("from")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    @ModelAttribute("to")
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    @ModelAttribute("subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    @ModelAttribute("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    
    
}
