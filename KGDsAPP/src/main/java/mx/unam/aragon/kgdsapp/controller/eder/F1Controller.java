package mx.unam.aragon.kgdsapp.controller.eder;


import mx.unam.aragon.kgdsapp.model.eder.Piloto;
import mx.unam.aragon.kgdsapp.service.eder.PilotoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paddock")
public class F1Controller {
    @Autowired
    private PilotoService pilotoService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Piloto> pilotos = pilotoService.getAllPilotos();
        model.addAttribute("pilotos", pilotos);
        return "/eder/home";
    }

    @GetMapping("/piloto")
    public String piloto(Model model) {
        Piloto piloto = new Piloto(1,"Oscar Piastri", "Mclaren"," Desde 2023 es piloto de McLaren en Fórmula 1, con la cual logró su primer podio en su año debut en el Gran Premio de Japón, primera victoria en el Gran Premio de Hungría de 2024, y primera pole position en el Gran Premio de China de 2025.",24, 81, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Oscar_Piastri.png/330px-Oscar_Piastri.png");
        model.addAttribute(piloto);
        return "/eder/piloto";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("piloto", new Piloto(1,"Oscar Piastri", "Mclaren"," Desde 2023 es piloto de McLaren en Fórmula 1, con la cual logró su primer podio en su año debut en el Gran Premio de Japón, primera victoria en el Gran Premio de Hungría de 2024, y primera pole position en el Gran Premio de China de 2025.",24, 81, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Oscar_Piastri.png/330px-Oscar_Piastri.png"));
        return "eder/formPiloto";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Piloto piloto
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardar piloto + " + piloto);
        // mandarlo a DB
        pilotoService.guardarPiloto(piloto);
        return "redirect:/paddock/home";
    }

    @GetMapping("/piloto/{id}")
    public String piloto(@PathVariable Integer id, Model model){
        model.addAttribute("piloto", pilotoService.getPiloto(id));
        return "/eder/piloto";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Piloto piloto = pilotoService.getPiloto(id);
        model.addAttribute("piloto", piloto);
        return "/eder/editarPiloto";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Piloto piloto) {
        pilotoService.guardarPiloto(piloto);
        return "redirect:/paddock/home";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, Model model) {
        Piloto piloto = pilotoService.getPiloto(id);
        model.addAttribute("piloto", piloto);
        return "/eder/confirmarEliminar";
    }

    @PostMapping("/eliminar")
    public String eliminarConfirmado(@RequestParam Integer id) {
        pilotoService.eliminarPiloto(id);
        return "redirect:/paddock/home";
    }
}
