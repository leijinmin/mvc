/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author 1697899
 */
@Controller
@RequestMapping(value="/Index")
public class HomeController  {
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("Accueil");
    } 
    
    @RequestMapping(value="/Logout", method=RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        new GestSession(request, Vars.NAME_ID, Vars.NAME_LIST).viderId();
        return "redirect:/Index";
    }
    
}
