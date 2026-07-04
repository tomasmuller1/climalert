package ar.edu.utn.frba.ddsi.climalert.controllers;

import ar.edu.utn.frba.ddsi.climalert.dto.registro.RegistroClimaticoResponse;
import ar.edu.utn.frba.ddsi.climalert.services.RegistroClimaticoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/climalert/registros")
public class RegistroClimaticoController {

    private final RegistroClimaticoService registroClimaticoService;

    public RegistroClimaticoController(RegistroClimaticoService registroClimaticoService) {
        this.registroClimaticoService = registroClimaticoService;
    }

    @GetMapping
    public List<RegistroClimaticoResponse> getAll() {
        return registroClimaticoService.findAll();
    }

    @GetMapping("/{id}")
    public RegistroClimaticoResponse getById(@PathVariable Long id) {
        return registroClimaticoService.findById(id);
    }
}
