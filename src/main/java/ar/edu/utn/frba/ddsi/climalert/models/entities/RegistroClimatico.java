package ar.edu.utn.frba.ddsi.climalert.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroClimatico {
    private Long id;
    private String ciudad;
    private Double temperaturaC;
    private Double humedad;
    private String condicion;
    private LocalDateTime fechaHora;
    private boolean evaluado;

    public void marcarComoEvaluado() {
        this.evaluado = true;
    }
}
