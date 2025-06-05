package mx.unam.aragon.kgdsapp.humberto;


import mx.unam.aragon.kgdsapp.model.eder.Piloto;
import mx.unam.aragon.kgdsapp.model.humberto.Operador;
import mx.unam.aragon.kgdsapp.service.humberto.OperadorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("mostrar")
    public String mostrar(Model model) {
        Operador operador = new Operador();
        model.addAttribute("operador", operador);
        return "mostrar";
    }

    @GetMapping("nuevo")
    public String nuevo(Model model) {
        model.addAttribute("operador", new Operador());
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Operador operador
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardado exitosamente" + operador);
        //Guardar en DB
        operadorService.guardarOperador(operador);
        return "redirect:/nuevo?exito";
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
