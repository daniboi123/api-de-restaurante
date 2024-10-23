package classicDiner.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoComida(@NotNull Long id,
                                     String nome,
                                     String email,
                                     DadosEndereco endereco) {
}
