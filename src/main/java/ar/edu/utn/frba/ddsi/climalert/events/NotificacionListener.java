package ar.edu.utn.frba.ddsi.climalert.events;

import ar.edu.utn.frba.ddsi.climalert.services.NotificacionService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionListener {

    private final NotificacionService notificacionService;

    public NotificacionListener(NotificacionService notificacionService) {
        this.notificacionService = notificacionService;
    }

    @EventListener
    public void onAlertaDetectada(AlertaDetectadaEvent event) {
        notificacionService.enviarAlerta(event.registro());
    }
}
