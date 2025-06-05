package mx.unam.aragon.kgdsapp.diego;

import mx.unam.aragon.kgdsapp.model.diego.Jugador;
import mx.unam.aragon.kgdsapp.service.diego.JugadorService;
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
        return "/diego/home";
    }

    @GetMapping("/jugador")
    public String jugador(Model model) {
        Jugador jugador = new Jugador();
        model.addAttribute(jugador);
        return "/diego/jugador";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("jugador", new Jugador());
        return "diego/formJugador";
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
        return "/diego/jugador";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Jugador jugador = jugadorService.getJugador(id);
        model.addAttribute("jugador", jugador);
        return "/diego/editarJugador";
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
        return "/diego/eliminar";
    }

    @PostMapping("/eliminar")
    public String eliminarConfirmado(@RequestParam Integer id) {
        jugadorService.eliminarJugador(id);
        return "redirect:/futbol/home";
    }
}