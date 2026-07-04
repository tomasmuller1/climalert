package ar.edu.utn.frba.ddsi.climalert.dto.error;

import java.time.Instant;

public record ErrorResponse(
        String error,
        String message,
        Instant timestamp
) {
}
