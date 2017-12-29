package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.MessageBoardMessage;
import sec.project.repository.MessageBoardRepository;

@Controller
public class MessageBoardController {
    
    @Autowired
    private MessageBoardRepository messageBoardRepository;
    
    @RequestMapping(value="/messageBoard", method = RequestMethod.GET)
    public String getMessageBoard(Model model) {       
        model.addAttribute("messages", messageBoardRepository.findAll());
        return "messageBoard";
    }
    
    @RequestMapping(value = "/messageBoard", method = RequestMethod.POST)
    public String submitForm(@RequestParam String subject, @RequestParam String message) {
        messageBoardRepository.save(new MessageBoardMessage(subject, message));
        return "redirect:/messageBoard";
    }
}
