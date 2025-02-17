package API_conserto.usuario;

import jakarta.validation.constraints.NotBlank;

public record dadosAutenticacao(
        @NotBlank
        String login,
        @NotBlank
        String senha
) {
}
