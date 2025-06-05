package mx.unam.aragon.kgdsapp.controller.r6;

import mx.unam.aragon.kgdsapp.model.r6.Operador;
import mx.unam.aragon.kgdsapp.service.r6.OperadorService;
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
        return "r6/home";
    }
    @GetMapping("/operador")
    public String mostrar(Model model) {
        Operador operador = new Operador();
        model.addAttribute("operador", operador);
        return "/r6/operador";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("operador", new Operador());
        return "r6/nuevoOperador";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Operador operador) {
        LoggerFactory.getLogger(getClass()).info("Guardar Operador +" + operador);
        operadorService.guardarOperador(operador);
        return "redirect:/r6/home";
    }

    @GetMapping("/operador/{id}")
    public String operador(@PathVariable long id, Model model){
        model.addAttribute("operador", operadorService.getOperador(id));
        return "/r6/operador";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model model) {
        Operador operador = operadorService.getOperador(id);
        model.addAttribute("operador", operador);
        return "/r6/editarOperador";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Operador operador) {
        operadorService.guardarOperador(operador);
        return "redirect:/r6/home";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable long id, Model model) {
        Operador operador = operadorService.getOperador(id);
        model.addAttribute("operador", operador);
        return "/r6/eliminar";
    }

    @PostMapping("/eliminar")
    public String eliminarConfirmado(@RequestParam long id) {
        operadorService.eliminarOperador(id);
        return "redirect:/r6/home";
    }
}
