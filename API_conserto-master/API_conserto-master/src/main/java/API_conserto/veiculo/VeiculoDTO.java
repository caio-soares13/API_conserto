package API_conserto.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoDTO(
        @NotBlank
        String marca,

        @NotBlank
        String modelo,
        @NotBlank
        @Pattern(regexp = "\\d{4}", message = "O ano deve estar no formato yyyy")
        String ano,

        String cor) {
}
