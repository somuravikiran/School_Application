package com.greetlabs.School_Application.controller;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.greetlabs.School_Application.model.Contact;
import com.greetlabs.School_Application.service.ContactService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContactController {

    private static Logger log=LoggerFactory.getLogger(ContactController.class);

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact",new Contact());
        return "contact";
    }

//    @PostMapping("/saveMsg")
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject,
//                                    @RequestParam String message){
//        log.info("Name : "+name);
//        log.info("Phone Number : "+mobileNum);
//        log.info("Subject : "+subject);
//        log.info("Email : "+email);
//        log.info("Message : "+message);
//        return new ModelAndView("redirect:/contact");
//    }

    @RequestMapping(value="/saveMsg", method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if (errors.hasErrors()){
            log.error("contact form validation failed due to : "+ errors.toString());
            return "contact";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        model.addAttribute("contactMsgs", contactMsgs);
        return new ModelAndView("message", "contactMsgs", contactMsgs);
    }

    @GetMapping(value = "/closeMsg")
    public String closeMsg(@RequestParam int id){
        contactService.updateMsgStatus(id);
        return "redirect:/displayMessages";
    }
}
