package API_conserto.controller;

import API_conserto.conserto.*;
import API_conserto.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ConsertoDTO dados, UriComponentsBuilder uriBuilder){
        Conserto conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body( new DadosDetalhamentoConserto(conserto) );

    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> listar(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAll(paginacao));
    }

    @GetMapping("algunsdados")
    public ResponseEntity listarAlgunsDados() {
        List<ListagemConsertoDTO> consertos= repository.findAllByAtivoTrue().stream().map(ListagemConsertoDTO::new).toList();
        return ResponseEntity.ok(consertos);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById( dados.id() );
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();

        return ResponseEntity.noContent().build();

    }


}
