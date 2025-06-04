package mx.unam.aragon.kgdsapp.service;

import mx.unam.aragon.kgdsapp.model.Operador;
import mx.unam.aragon.kgdsapp.repositorie.OperadorRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadorService {
    @Autowired
    private OperadorRepositorie operadorRepositorie;

    public boolean guardarOperador(Operador operador) {
        Operador resultado = operadorRepositorie.save(operador);
        return resultado != null;
    }



}
