package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.models.entities.EvaluadorClimatico;
import ar.edu.utn.frba.ddsi.climalert.events.AlertaDetectadaEvent;
import ar.edu.utn.frba.ddsi.climalert.repositories.RegistroClimaticoRepository;
import ar.edu.utn.frba.ddsi.climalert.services.EvaluadorAlertasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EvaluadorAlertasServiceImpl implements EvaluadorAlertasService {

    private final RegistroClimaticoRepository registroClimaticoRepository;
    private final EvaluadorClimatico evaluadorClimatico;
    private final ApplicationEventPublisher eventPublisher;

    public EvaluadorAlertasServiceImpl(
            RegistroClimaticoRepository registroClimaticoRepository,
            EvaluadorClimatico evaluadorClimatico,
            ApplicationEventPublisher eventPublisher) {
        this.registroClimaticoRepository = registroClimaticoRepository;
        this.evaluadorClimatico = evaluadorClimatico;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void evaluarUltimoRegistro() {
        registroClimaticoRepository.findLast().ifPresent(registro -> {
            if (registro.isEvaluado()) {
                return;
            }
            registro.marcarComoEvaluado();

            if (evaluadorClimatico.hayAlerta(registro)) {
                log.warn("Alerta climática detectada para el registro {}", registro.getId());
                eventPublisher.publishEvent(new AlertaDetectadaEvent(registro));
            }
        });
    }
}
