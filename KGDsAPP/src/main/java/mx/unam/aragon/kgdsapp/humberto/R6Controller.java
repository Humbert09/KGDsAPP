package mx.unam.aragon.kgdsapp.humberto;


import mx.unam.aragon.kgdsapp.model.eder.Piloto;
import mx.unam.aragon.kgdsapp.model.humberto.Operador;
import mx.unam.aragon.kgdsapp.service.humberto.OperadorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/r6")
public class R6Controller {

    @Autowired
    private OperadorService operadorService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Operador> operadors = operadorService.getAllOperadores();
        model.addAttribute("operadors", operadors);
        return "/humberto/home";
    }

    @GetMapping("/operador")
    public String operador(Model model) {
    Operador operador = new Operador(1L, "Sledge", "SAS", "Ataque", 33, 10, "https://staticctf.ubisoft.com/J3yJr34U2pZ2Ieem48Dwy9uqj5PNUQTn/16NXiE9PBhzEJvusXHKALJ/11ced4b21f6bde42662cfe93fee31641/R6-operator-sledge-elite.png");
        model.addAttribute(operador);
        return "/humberto/operador";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("operador", new Operador(1L, "Sledge", "SAS", "Ataque", 33, 10, "https://staticctf.ubisoft.com/J3yJr34U2pZ2Ieem48Dwy9uqj5PNUQTn/16NXiE9PBhzEJvusXHKALJ/11ced4b21f6bde42662cfe93fee31641/R6-operator-sledge-elite.png"));
        return "/humberto/nuevoOperador";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Operador operador
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardar operador + " + operador);
        // mandarlo a DB
        operadorService.guardarOperador(operador);
        return "redirect:/r6/home";
    }

    @GetMapping("/operador/{id}")
    public String operador(@PathVariable Long id, Model model){
        model.addAttribute("operador", operadorService.getOperador(id));
        return "/humberto/operador";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Operador operador = operadorService.getOperador(id);
        model.addAttribute("operdador", operador);
        return "/humberto/modificarOperador";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Operador operador) {
        operadorService.guardarOperador(operador);
        return "redirect:/r6/home";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model) {
        Operador operador = operadorService.getOperador(id);
        model.addAttribute("operador", operador);
        return "/humberto/eliminarOperador";
    }

    @PostMapping("/eliminar")
    public String eliminarConfirmado(@RequestParam Long id) {
        operadorService.eliminarOperador(id);
        return "redirect:/r6/home";
    }


}
