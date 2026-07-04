package ar.edu.utn.frba.ddsi.climalert.schedulers;

import ar.edu.utn.frba.ddsi.climalert.services.RecoleccionClimaticaService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RecoleccionClimaticaScheduler {

    private final RecoleccionClimaticaService recoleccionClimaticaService;

    public RecoleccionClimaticaScheduler(RecoleccionClimaticaService recoleccionClimaticaService) {
        this.recoleccionClimaticaService = recoleccionClimaticaService;
    }

    @Scheduled(fixedRateString = "${climalert.scheduler.recoleccion.fixed-rate}")
    public void ejecutar() {
        recoleccionClimaticaService.recolectar();
    }
}