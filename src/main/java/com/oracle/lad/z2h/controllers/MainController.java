package com.oracle.lad.z2h.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    @RequestMapping({"/"})
    public String index(final Model model) {
        return "index";
    }
}
