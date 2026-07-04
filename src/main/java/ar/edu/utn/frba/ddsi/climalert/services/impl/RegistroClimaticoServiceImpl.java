package ar.edu.utn.frba.ddsi.climalert.services.impl;

import ar.edu.utn.frba.ddsi.climalert.dto.registro.RegistroClimaticoResponse;
import ar.edu.utn.frba.ddsi.climalert.exceptions.ResourceNotFoundException;
import ar.edu.utn.frba.ddsi.climalert.repositories.RegistroClimaticoRepository;
import ar.edu.utn.frba.ddsi.climalert.services.RegistroClimaticoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroClimaticoServiceImpl implements RegistroClimaticoService {

    private final RegistroClimaticoRepository registroClimaticoRepository;

    public RegistroClimaticoServiceImpl(RegistroClimaticoRepository registroClimaticoRepository) {
        this.registroClimaticoRepository = registroClimaticoRepository;
    }

    @Override
    public List<RegistroClimaticoResponse> findAll() {
        return registroClimaticoRepository.findAll().stream()
                .map(RegistroClimaticoResponse::from)
                .toList();
    }

    @Override
    public RegistroClimaticoResponse findById(Long id) {
        return registroClimaticoRepository.findById(id)
                .map(RegistroClimaticoResponse::from)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró registro climático con id " + id));
    }
}
