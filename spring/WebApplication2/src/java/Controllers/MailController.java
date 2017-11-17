/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import Models.Email;
import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import javax.mail.*;
/**
 *
 * @author JINMIN
 */
@Controller
@RequestMapping("/Mail")
public class MailController {
    
    // Destination
    private static final String TO = "leijinmin@gmail.com";       
    //host information
    private static final String HOST_USER = "dishmoon@msn.com";       
    private static final String HOST_PASSWORD = "123456";      
    private static final int HOST_PORT = 587;

    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView send() {
        // Remplir les donnèes comme un example pour montrer le binding du modèle
        return new ModelAndView("SendEmail","email",new Email("leijinmin@gmail.com","dishmoon@msn.com","Un test","Le contenu ici."));
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String send(@ModelAttribute Email email, BindingResult result) {
        EmailValidator formValidation = new EmailValidator();  
        formValidation.validate(email, result);
        
        if(result.hasErrors())
            return "SendEmail";
        
        SimpleMailMessage message = new SimpleMailMessage();  
        message.setFrom(email.getFrom());  
        message.setTo(TO);  
        message.setSubject(email.getSubject());  
        message.setText(email.getMessage()); 
        
        javaMailSender().send(message);
        
        return "redirect:/Index";
 /**
  * http://android.wekeepcoding.com/article/11670327/JavaMail+Exception+%3A+STOREDRV.Submission.Exception%3AOutboundSpamException
  * sending failed due to :
  * this is outlook security, It need using web to login.
    you can also check this mail to unlock your account.
    Hello xxxxx,
    To continue sending messages, please sign in and validate your Outlook.com account.
    This helps us stop automated programs from sending junk email.
    Thanks for your help and patience!
    The Outlook.com Team
  */        
    }
    
      public JavaMailSender javaMailSender() {
          
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setJavaMailProperties(new Properties(){{
            put("mail.smtp.auth", true);
            put("mail.smtp.starttls.enable", true);
            put("mail.smtp.starttls.required", true);            
        }});

        mailSender.setHost("smtp-mail.outlook.com");
        mailSender.setPort(HOST_PORT);
        mailSender.setProtocol("smtp");
        mailSender.setUsername(HOST_USER);
        mailSender.setPassword(HOST_PASSWORD);
        
        return mailSender;
    }  

}
