package mx.unam.aragon.kgdsapp.service.futbol;

import mx.unam.aragon.kgdsapp.model.futbol.Jugador;
import mx.unam.aragon.kgdsapp.repositorie.futbol.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public boolean guardarJugador(Jugador jugador) {
        Jugador result = jugadorRepository.save(jugador);
        return result != null;
    }

    public Jugador getJugador(Integer id) {
        return jugadorRepository.getById(id);
    }

    public List<Jugador> getAllJugadors() {
        return jugadorRepository.findAll();
    }

    public void eliminarJugador(Integer id) { jugadorRepository.deleteById(id);
    }

}
