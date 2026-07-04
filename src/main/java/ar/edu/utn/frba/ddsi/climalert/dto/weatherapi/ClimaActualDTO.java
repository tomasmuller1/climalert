package ar.edu.utn.frba.ddsi.climalert.dto.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimaActualDTO {

    @JsonProperty("temp_c")
    private Double temperaturaC;

    @JsonProperty("humidity")
    private Double humedad;

    @JsonProperty("condition")
    private CondicionDTO condicion;

    @JsonProperty("last_updated")
    private String ultimaActualizacion;
}
