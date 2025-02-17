package API_conserto.conserto;

import API_conserto.mecanico.MecanicoDTO;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        String dataSaida,
        MecanicoDTO mecanico

) { };
