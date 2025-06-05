package mx.unam.aragon.kgdsapp.service.humberto;

import mx.unam.aragon.kgdsapp.model.eder.Piloto;
import mx.unam.aragon.kgdsapp.model.humberto.Operador;
import mx.unam.aragon.kgdsapp.repositorie.humberto.OperadorRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadorService {
    @Autowired
    private OperadorRepositorie operadorRepositorie;

    public boolean guardarOperador(Operador operador) {
        Operador resultado = operadorRepositorie.save(operador);
        return resultado != null;
    }

    public Operador getOperador(Long id) {
        return operadorRepositorie.getById(id);
    }

    public List<Operador> getAllOperadores() {
        return operadorRepositorie.findAll();
    }

    public void eliminarOperador(Long id) {
        operadorRepositorie.deleteById(id);
    }


}
