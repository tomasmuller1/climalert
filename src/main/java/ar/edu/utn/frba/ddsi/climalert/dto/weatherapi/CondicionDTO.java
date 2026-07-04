package ar.edu.utn.frba.ddsi.climalert.dto.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CondicionDTO {

    @JsonProperty("text")
    private String texto;
}
