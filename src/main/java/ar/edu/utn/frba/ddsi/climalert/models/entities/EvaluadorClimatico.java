package ar.edu.utn.frba.ddsi.climalert.models.entities;

import ar.edu.utn.frba.ddsi.climalert.models.entities.reglas.ReglaAlerta;

public class EvaluadorClimatico {

    private final ReglaAlerta regla;

    public EvaluadorClimatico(ReglaAlerta regla) {
        this.regla = regla;
    }

    public boolean hayAlerta(RegistroClimatico registro) {
        return regla.esAlerta(registro);
    }
}
