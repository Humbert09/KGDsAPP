package mx.unam.aragon.kgdsapp.service.r6;

import mx.unam.aragon.kgdsapp.model.r6.Operador;
import mx.unam.aragon.kgdsapp.repositorie.r6.OperadorRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadorService {
    @Autowired
    private OperadorRepositorie operadorRepositorie;

    public Operador guardarOperador(Operador operador) {
        return operadorRepositorie.save(operador);
    }


    public Operador getOperador(Long id) {
        return operadorRepositorie.findById(id).orElse(null);
    }

    public List<Operador> getAllOperadores() {
        return operadorRepositorie.findAll();
    }

    public void eliminarOperador(Long id) {
        operadorRepositorie.deleteById(id);
    }


}
