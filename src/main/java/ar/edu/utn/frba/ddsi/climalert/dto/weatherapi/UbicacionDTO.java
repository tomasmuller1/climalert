package ar.edu.utn.frba.ddsi.climalert.dto.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UbicacionDTO {

    @JsonProperty("name")
    private String nombre;

    private String region;

    @JsonProperty("country")
    private String pais;
}
