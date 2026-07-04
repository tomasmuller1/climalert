package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;

public interface NotificacionService {

    void enviarAlerta(RegistroClimatico registro);
}
