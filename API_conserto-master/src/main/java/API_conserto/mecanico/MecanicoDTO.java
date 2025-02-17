package API_conserto.mecanico;

import jakarta.validation.constraints.NotBlank;

public record MecanicoDTO(
        @NotBlank
        String nome,
        String anosExperiencia) {
}
