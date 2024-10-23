package classicDiner.api.model;

import classicDiner.api.dto.DadosAtualizacaoComida;
import classicDiner.api.dto.DadosCadastroComida;
import classicDiner.api.dto.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "Comidas")
@Entity(name = "Comida")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Integer preco;
    private String comida;

//    @Enumerated(EnumType.STRING)
//    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Comida(DadosCadastroComida dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.comida = dados.comida();
        this.preco = dados.preco();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacaoes(DadosAtualizacaoComida dados) {
        if (dados != null){
        this.nome = dados.nome();
    }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacaoes(dados.endereco());
        }
}

    public void excluir() {
        this.ativo = false;
    }
}
