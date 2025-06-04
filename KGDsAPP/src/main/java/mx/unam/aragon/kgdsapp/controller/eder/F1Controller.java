package mx.unam.aragon.kgdsapp.controller.eder;


import mx.unam.aragon.kgdsapp.model.eder.Piloto;
import mx.unam.aragon.kgdsapp.service.eder.PilotoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paddock")
public class F1Controller {
    @Autowired
    private PilotoService pilotoService;

    @GetMapping("/home")
    public String home() {
        return "/eder/home";
    }

    @GetMapping("/piloto")
    public String piloto(Model model) {
        Piloto piloto = new Piloto(1,"Oscar Piastri", "Mclaren",24, 81, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Oscar_Piastri.png/330px-Oscar_Piastri.png");
        model.addAttribute(piloto);
        return "/eder/piloto";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("piloto", new Piloto(1,"Pon uno", "Sepa",90, 0, "algo"));
        return "eder/formPiloto";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Piloto piloto
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardar piloto + " + piloto);
        // mandarlo a DB
        pilotoService.guardarPiloto(piloto);
        return "redirect:/paddock/nuevo?exito";
    }

    @GetMapping("/piloto/{id}")
    public String piloto(@PathVariable Integer id, Model model){
        model.addAttribute("piloto", pilotoService.getPiloto(id));
        return "/eder/piloto";
    }
}
