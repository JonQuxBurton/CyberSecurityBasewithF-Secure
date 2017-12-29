package sec.project.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookHotelController {
    
    @RequestMapping(value = "/bookHotel", method = RequestMethod.GET)
    public String bookHotel(Authentication authentication, Model model, @RequestParam int stars) {
        model.addAttribute("stars", stars);
        
        return "bookHotel";
    }
}
