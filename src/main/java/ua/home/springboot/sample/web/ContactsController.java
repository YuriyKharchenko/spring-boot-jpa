package ua.home.springboot.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.home.springboot.sample.ProhibitionException;
import ua.home.springboot.sample.model.Contact;
import ua.home.springboot.sample.model.User;
import ua.home.springboot.sample.repository.ContactRepository;
import ua.home.springboot.sample.repository.UserRepository;
import ua.home.springboot.sample.service.SecurityService;
import ua.home.springboot.sample.service.SecurityServiceImpl;
import ua.home.springboot.sample.service.UserService;
import ua.home.springboot.sample.xml.XmlProcessor;

import javax.validation.Valid;
import java.io.File;
import java.util.List;

@Controller
public class ContactsController {

    private static final File XmlToFile = new File("main.xml");


    @Autowired
    ContactRepository contactRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    XmlProcessor xmlProcessor;

    @Autowired
    private SecurityService securityService = new SecurityServiceImpl();

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String showAllContacts(Model model) {
        String name = securityService.getName();
        User user = userService.findByUsername(name);
        model.addAttribute("contacts", contactRepository.findByUserId(user.getId()));
        return "contacts";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST) // add contact
    public String saveOrUpdateContact(@ModelAttribute("contactForm") @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("what are you writing, Man?!");
            return "form";
        }
        String name = securityService.getName();
        User user = userService.findByUsername(name);
        contact.setUserId(user.getId());
        contactRepository.save(contact);

        rewriteXml();

        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/add", method = RequestMethod.GET)
    public String showAddContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contactForm", contact);

        return "form";
    }

    @RequestMapping(value = "/contacts/{id}/delete", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") Long id) {
        contactRepository.delete(contactRepository.findOne(id));
        rewriteXml();

        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/{id}/update", method = RequestMethod.GET)
    public String updateContact(@PathVariable Long id, Model model) {
        Contact contact = contactRepository.findOne(id);
        model.addAttribute("contactForm", contact);
        return "form";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String searchByName(@RequestParam("lastname") String lastname, ModelMap modelMap) {
        if (lastname == null || lastname == "") {
            return "redirect:/contacts";
        } else {
            Contact contact = contactRepository.findByLastName(lastname);
            if (lastname == null) {
                throw new ProhibitionException("There is no such contact.");
            } else {
                modelMap.addAttribute("contactic", contact);
                return "/find";
            }
        }
    }

    private void rewriteXml() {
        List<Contact> list = contactRepository.findAll();
        xmlProcessor.writeData(list, XmlToFile);
    }
}