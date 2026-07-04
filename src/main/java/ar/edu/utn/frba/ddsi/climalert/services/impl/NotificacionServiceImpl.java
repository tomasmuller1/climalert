package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;
import ar.edu.utn.frba.ddsi.climalert.services.NotificacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class NotificacionServiceImpl implements NotificacionService {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final JavaMailSender mailSender;
    private final List<String> destinatarios;

    public NotificacionServiceImpl(
            JavaMailSender mailSender,
            @Value("#{'${climalert.alerta.destinatarios}'.split(',')}") List<String> destinatarios) {
        this.mailSender = mailSender;
        this.destinatarios = destinatarios;
    }

    @Override
    public void enviarAlerta(RegistroClimatico registro) {
        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(destinatarios.toArray(new String[0]));
            mensaje.setSubject("[Climalert] Alerta climática en " + registro.getCiudad());
            mensaje.setText(construirCuerpo(registro));
            mailSender.send(mensaje);
            log.info("Mail de alerta enviado a {}", destinatarios);
        } catch (Exception e) {
            log.error("Error al enviar el mail de alerta", e);
        }
    }

    private String construirCuerpo(RegistroClimatico registro) {
        return """
                Se detectó una alerta climática: la temperatura y la humedad superaron los umbrales configurados.

                Detalle del registro:
                - Ciudad: %s
                - Temperatura: %.1f °C
                - Humedad: %.1f %%
                - Condición: %s
                - Fecha y hora: %s
                """.formatted(
                registro.getCiudad(),
                registro.getTemperaturaC(),
                registro.getHumedad(),
                registro.getCondicion(),
                registro.getFechaHora().format(FORMATO_FECHA)
        );
    }
}
