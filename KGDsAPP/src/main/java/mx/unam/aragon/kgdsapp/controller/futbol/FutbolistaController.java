package mx.unam.aragon.kgdsapp.controller.futbol;

import mx.unam.aragon.kgdsapp.model.futbol.Jugador;
import mx.unam.aragon.kgdsapp.service.futbol.JugadorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/futbol")

public class FutbolistaController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Jugador> jugadors = jugadorService.getAllJugadors();
        model.addAttribute("jugadores", jugadors);
        return "/futbol/home";
    }

    @GetMapping("/jugador")
    public String jugador(Model model) {
        Jugador jugador = new Jugador(1, "Lionel Andrés Messi Cuccittini", "MiamiFc", "El mejor jugador del mundo", 37, 10, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg/250px-Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg");
        model.addAttribute(jugador);
        return "/futbol/jugador";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("jugador", new Jugador(1, "Lionel Andrés Messi Cuccittini", "MiamiFc", "El mejor jugador del mundo", 37, 10, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg/250px-Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg"));
        return "futbol/formJugador";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute Jugador jugador
    ) {
        LoggerFactory.getLogger(getClass()).info("Guardar jugador + " + jugador);
        jugadorService.guardarJugador(jugador);
        return "redirect:/futbol/home";
    }

    @GetMapping("/jugador/{id}")
    public String jugador(@PathVariable Integer id, Model model){
        model.addAttribute("jugador", jugadorService.getJugador(id));
        return "/futbol/jugador";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Jugador jugador = jugadorService.getJugador(id);
        model.addAttribute("jugador", jugador);
        return "/futbol/editarJugador";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Jugador jugador) {
        jugadorService.guardarJugador(jugador);
        return "redirect:/futbol/home";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, Model model) {
        Jugador jugador = jugadorService.getJugador(id);
        model.addAttribute("jugador", jugador);
        return "/futbol/eliminar";
    }

    @PostMapping("/eliminar")
    public String eliminarConfirmado(@RequestParam Integer id) {
        jugadorService.eliminarJugador(id);
        return "redirect:/futbol/home";
    }
}