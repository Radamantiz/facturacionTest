package com.Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private ClienteRepository r;

    @GetMapping("/add")
    public String addHome(Model model){
        model.addAttribute("cliente", new Cliente());
        return "addCliente";
    }

    @GetMapping("/test")
    public @ResponseBody
    Iterable<Cliente> mostrarClientes(){
        return r.findAll();
    }

    @GetMapping({"/all","/"})
    public String mostrarAll(Model model){
        model.addAttribute("clientes", r.findAll());
        return "home";
    }
    @PostMapping("/add")
    public String addNew(@ModelAttribute Cliente cliente){
        r.save(cliente);
        return "redirect:/all";
    }

}
