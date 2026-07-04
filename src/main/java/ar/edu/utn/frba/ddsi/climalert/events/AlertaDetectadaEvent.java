package ar.edu.utn.frba.ddsi.climalert.events;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;

public record AlertaDetectadaEvent(RegistroClimatico registro) {
}
