package ar.edu.utn.frba.ddsi.climalert.schedulers;

import ar.edu.utn.frba.ddsi.climalert.services.EvaluadorAlertasService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EvaluacionAlertaScheduler {

    private final EvaluadorAlertasService evaluadorAlertasService;

    public EvaluacionAlertaScheduler(EvaluadorAlertasService evaluadorAlertasService) {
        this.evaluadorAlertasService = evaluadorAlertasService;
    }

    @Scheduled(fixedRateString = "${climalert.scheduler.evaluacion.fixed-rate}")
    public void ejecutar() {
        evaluadorAlertasService.evaluarUltimoRegistro();
    }
}