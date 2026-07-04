package ar.edu.utn.frba.ddsi.climalert.config;

import ar.edu.utn.frba.ddsi.climalert.models.entities.EvaluadorClimatico;
import ar.edu.utn.frba.ddsi.climalert.models.entities.reglas.ReglaAlerta;
import ar.edu.utn.frba.ddsi.climalert.models.entities.reglas.ReglaTemperaturaHumedadAlta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReglasAlertaConfig {

    private final double temperaturaUmbral;
    private final double humedadUmbral;

    public ReglasAlertaConfig(
            @Value("${climalert.alerta.temperatura-umbral}") double temperaturaUmbral,
            @Value("${climalert.alerta.humedad-umbral}") double humedadUmbral) {
        this.temperaturaUmbral = temperaturaUmbral;
        this.humedadUmbral = humedadUmbral;
    }

    @Bean
    public EvaluadorClimatico evaluadorClimatico() {
        ReglaAlerta regla = new ReglaTemperaturaHumedadAlta(temperaturaUmbral, humedadUmbral);
        return new EvaluadorClimatico(regla);
    }
}
