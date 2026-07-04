package ar.edu.utn.frba.ddsi.climalert.dto.registro;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;

import java.time.LocalDateTime;

public record RegistroClimaticoResponse(
        Long id,
        String ciudad,
        Double temperaturaC,
        Double humedad,
        String condicion,
        LocalDateTime fechaHora
) {
    public static RegistroClimaticoResponse from(RegistroClimatico registro) {
        return new RegistroClimaticoResponse(
                registro.getId(),
                registro.getCiudad(),
                registro.getTemperaturaC(),
                registro.getHumedad(),
                registro.getCondicion(),
                registro.getFechaHora()
        );
    }
}
