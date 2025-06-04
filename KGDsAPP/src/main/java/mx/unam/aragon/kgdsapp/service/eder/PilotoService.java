package mx.unam.aragon.kgdsapp.service.eder;

import mx.unam.aragon.kgdsapp.model.eder.Piloto;
import mx.unam.aragon.kgdsapp.repositorie.eder.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotoService {
    @Autowired
    private PilotoRepository pilotoRepository;

    public boolean guardarPiloto(Piloto piloto) {
        Piloto result = pilotoRepository.save(piloto);
        return result != null;
    }

    public Piloto getPiloto(Integer id) {
        return pilotoRepository.getById(id);
    }
}
