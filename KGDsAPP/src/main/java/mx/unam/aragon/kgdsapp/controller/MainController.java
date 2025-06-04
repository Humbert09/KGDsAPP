package mx.unam.aragon.kgdsapp.controller;


import mx.unam.aragon.kgdsapp.model.Operador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("mostrar")
    public String mostrar(Model model) {
        Operador operador = new Operador();
        model.addAttribute("operador", operador);
        return "mostrar";
    }

    @GetMapping("nuevo")
    public String nuevo() {
        return "nuevo";
    }

    @GetMapping("modificar")
    public String modificar() {
        return "modificar";
    }

    @GetMapping("eliminar")
    public String eliminar() {
        return "eliminar";
    }
}
