package ar.edu.utn.frba.ddsi.climalert.models.entities.reglas;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;

// PATRÓN STRATEGY
public interface ReglaAlerta {

    boolean esAlerta(RegistroClimatico registro);
}
