/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.util.regex.Pattern;  
  
import org.springframework.validation.Errors;  
import org.springframework.validation.ValidationUtils;  
import org.springframework.validation.Validator;  

import Models.Email;

/**
 *
 * @author JINMIN
 */
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";   
    
    @Override
    public boolean supports(Class<?> type) {
       return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Email email = (Email)o;
        String from = email.getFrom();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "from", "required.from", "Le champs From ne peut pas être vide. ");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "required.subject", "Le champs Subject ne peut pas être vide. ");
       
        if (from != null && !from.isEmpty() && !Pattern.compile(EMAIL_PATTERN).matcher(from).matches()) {   
             errors.rejectValue("from", "from.incorrect","Le format du courriel n'est pas correct.");  
        }  
    }
    
}
