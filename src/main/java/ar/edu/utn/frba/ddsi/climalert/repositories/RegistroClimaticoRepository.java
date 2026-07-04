package ar.edu.utn.frba.ddsi.climalert.repositories;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;

import java.util.List;
import java.util.Optional;

public interface RegistroClimaticoRepository {

    RegistroClimatico save(RegistroClimatico registro);

    Optional<RegistroClimatico> findById(Long id);

    Optional<RegistroClimatico> findLast();

    List<RegistroClimatico> findAll();
}
