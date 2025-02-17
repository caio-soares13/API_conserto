package API_conserto.conserto;

import API_conserto.mecanico.Mecanico;
import API_conserto.mecanico.MecanicoDTO;
import API_conserto.veiculo.Veiculo;
import API_conserto.veiculo.VeiculoDTO;

public record DadosDetalhamentoConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        Mecanico mecanico,
        Veiculo veiculo) {

    public DadosDetalhamentoConserto(Conserto conserto){
        this( conserto.getId(), conserto.getDataEntrada(), conserto.getDataSaida(),
                conserto.getMecanico(), conserto.getVeiculo());
    }

}
