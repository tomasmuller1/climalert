package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.clients.WeatherApiClient;
import ar.edu.utn.frba.ddsi.climalert.dto.weatherapi.WeatherApiResponse;
import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;
import ar.edu.utn.frba.ddsi.climalert.repositories.RegistroClimaticoRepository;
import ar.edu.utn.frba.ddsi.climalert.services.RecoleccionClimaticaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class RecoleccionClimaticaServiceImpl implements RecoleccionClimaticaService {

    private final WeatherApiClient weatherApiClient;
    private final RegistroClimaticoRepository registroClimaticoRepository;
    private final String ubicacion;

    public RecoleccionClimaticaServiceImpl(
            WeatherApiClient weatherApiClient,
            RegistroClimaticoRepository registroClimaticoRepository,
            @Value("${climalert.ubicacion}") String ubicacion) {
        this.weatherApiClient = weatherApiClient;
        this.registroClimaticoRepository = registroClimaticoRepository;
        this.ubicacion = ubicacion;
    }

    @Override
    public void recolectar() {
        try {
            WeatherApiResponse respuesta = weatherApiClient.obtenerClimaActual(ubicacion);
            RegistroClimatico registro = mapearRegistro(respuesta);
            registroClimaticoRepository.save(registro);
            log.info("Registro climático guardado: {}", registro);
        } catch (Exception e) {
            log.error("Error al recolectar datos climáticos de WeatherAPI", e);
        }
    }

    private RegistroClimatico mapearRegistro(WeatherApiResponse respuesta) {
        return RegistroClimatico.builder()
                .ciudad(respuesta.getUbicacion().getNombre())
                .temperaturaC(respuesta.getClimaActual().getTemperaturaC())
                .humedad(respuesta.getClimaActual().getHumedad())
                .condicion(respuesta.getClimaActual().getCondicion().getTexto())
                .fechaHora(LocalDateTime.now())
                .build();
    }
}