package sec.project.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @PersistenceContext
    private EntityManager entityManager;
    
    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm(Authentication authentication, Model model) {
        
        List<Signup> signups = signupRepository.findByUsername(authentication.getName());
        
        if (!signups.isEmpty()) {
            return "alreadySignedup";
        }
        
        if ("satoshi".equals(authentication.getName()))
            model.addAttribute("isAdmin", true);
        else
            model.addAttribute("isAdmin", false);
            
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(Authentication authentication, @RequestParam String name, @RequestParam String address) {
        signupRepository.save(new Signup(authentication.getName(), name, address));
        return "done";
    }
    
    @RequestMapping(value = "/showSearch", method = RequestMethod.GET)
    public String showSearch() {
        return "search";
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam String search) {
        
        if (search != null) {
            Query query = entityManager.createQuery("Select new sec.project.domain.Signup(username, name, address) from Signup where isSecret = false and name = '" + search + "'");       
            List<Signup> results = query.getResultList();
            model.addAttribute("signups", results);
        }
        else{
            model.addAttribute("signups", new ArrayList<Signup>());
        }
        
        return "search";
    }
    
    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancel(Authentication authentication, Model model) {
        List<Signup> signups = signupRepository.findByUsername(authentication.getName());
        
        signupRepository.delete(signups.get(0));
        
        return "redirect:/form";
    }
}
