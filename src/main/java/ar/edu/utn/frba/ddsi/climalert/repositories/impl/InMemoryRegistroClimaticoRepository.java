package ar.edu.utn.frba.ddsi.climalert.repositories.impl;

import ar.edu.utn.frba.ddsi.climalert.models.entities.RegistroClimatico;
import ar.edu.utn.frba.ddsi.climalert.repositories.RegistroClimaticoRepository;
import ar.edu.utn.frba.ddsi.climalert.utils.GeneradorIdSecuencial;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryRegistroClimaticoRepository implements RegistroClimaticoRepository {

    private final List<RegistroClimatico> registros = new ArrayList<>();
    private final GeneradorIdSecuencial generadorId = new GeneradorIdSecuencial();

    @Override
    public RegistroClimatico save(RegistroClimatico registro) {
        registro.setId(generadorId.siguiente());
        registros.add(registro);
        return registro;
    }

    @Override
    public Optional<RegistroClimatico> findById(Long id) {
        return registros.stream()
                .filter(registro -> registro.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<RegistroClimatico> findLast() {
        if (registros.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(registros.get(registros.size() - 1));
    }

    @Override
    public List<RegistroClimatico> findAll() {
        return List.copyOf(registros);
    }
}
