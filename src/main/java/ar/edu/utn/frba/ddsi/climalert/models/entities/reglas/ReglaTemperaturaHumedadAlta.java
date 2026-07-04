package ar.edu.utn.frba.ddsi.climalert.models.entities.reglas;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;

public class ReglaTemperaturaHumedadAlta implements ReglaAlerta {

    private final double temperaturaUmbral;
    private final double humedadUmbral;

    public ReglaTemperaturaHumedadAlta(double temperaturaUmbral, double humedadUmbral) {
        this.temperaturaUmbral = temperaturaUmbral;
        this.humedadUmbral = humedadUmbral;
    }

    @Override
    public boolean esAlerta(RegistroClimatico registro) {
        return registro.getTemperaturaC() > temperaturaUmbral && registro.getHumedad() > humedadUmbral;
    }
}
