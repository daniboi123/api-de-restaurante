package classicDiner.api.controller;

import classicDiner.api.dto.DadosAtualizacaoComida;
import classicDiner.api.dto.DadosCadastroComida;
import classicDiner.api.dto.DadosListagemComida;
import classicDiner.api.dto.Endereco;
import classicDiner.api.model.Comida;
import classicDiner.api.repository.ComidaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comida")
public class ComidaController {
    @Autowired
    private ComidaRepository repository;
    @PostMapping
    //atenção no transsacitional na importação
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroComida dados){
        repository.save(new Comida(dados));
    }
    @GetMapping
    public Page<DadosListagemComida> listar(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao)
                .map(DadosListagemComida::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoComida dados){
        var comida = repository.getReferenceById(dados.id());
        comida.atualizarInformacaoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var comida = repository.getReferenceById(id);
        comida.excluir();
    }

}
