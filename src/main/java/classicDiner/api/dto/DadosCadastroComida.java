package classicDiner.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroComida(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @Max(value = 130)
        Integer preco,
        @NotBlank
        String comida,
        @NotNull @Valid DadosEndereco endereco) {
}
