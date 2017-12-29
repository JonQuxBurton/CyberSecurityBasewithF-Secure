package sec.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
    
    @RequestMapping("/admin")
    public String getAdmin() {
        return "admin";
    }   
}
