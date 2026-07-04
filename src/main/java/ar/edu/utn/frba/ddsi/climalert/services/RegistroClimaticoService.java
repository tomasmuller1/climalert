package ar.edu.utn.frba.ddsi.climalert.services;

import ar.edu.utn.frba.ddsi.climalert.dto.registro.RegistroClimaticoResponse;

import java.util.List;

public interface RegistroClimaticoService {

    List<RegistroClimaticoResponse> findAll();

    RegistroClimaticoResponse findById(Long id);
}
