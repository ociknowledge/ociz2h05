package com.oracle.lad.z2h.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oracle.lad.z2h.model.Person;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.oracle.lad.z2h.repository.PersonRepository;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {

    static final String ROUTE_URL = "/person";
    static String ROUTE_STR;
    private final PersonRepository repository;

    @Autowired
    public PersonController(final PersonRepository repository) {
        this.repository = repository;
    }

    @RequestMapping({"/person"})
    public String index(final Model model) {
        model.addAttribute("objeto", (Object) new Person());
        model.addAttribute("listado", (Object) this.repository.findAll());
        return PersonController.ROUTE_STR;
    }

    @PostMapping({"/person/save"})
    public String save(final Person objeto, final Model model) {
        if (objeto != null) {
            if (objeto.getId() != 0) {
                this.repository.update(objeto);
            } else {
                this.repository.create(objeto);
            }
        }
        model.addAttribute("objeto", (Object) new Person());
        model.addAttribute("listado", (Object) this.repository.findAll());
        return "redirect:/person";
    }

    @GetMapping({"/person/del/{id}"})
    public String delete(@PathVariable("id") final int id, final Model model) {
        this.repository.deleteById(id);
        model.addAttribute("objeto", (Object) new Person());
        model.addAttribute("listado", (Object) this.repository.findAll());
        return "redirect:/person";
    }

    @GetMapping({"/person/edit/{id}"})
    public String edit(@PathVariable("id") final int id, final Model model) {
        model.addAttribute("objeto", (Object) this.repository.findById(id));
        model.addAttribute("listado", (Object) this.repository.findAll());
        return PersonController.ROUTE_STR;
    }

    static {
        PersonController.ROUTE_STR = "person";
    }
}
