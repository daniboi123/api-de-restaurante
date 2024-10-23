package classicDiner.api.dto;

import classicDiner.api.model.Comida;

public record DadosListagemComida(Long id,String nome, String email, String crm, String comida, Integer preco) {

    public DadosListagemComida(Comida comida){
        this(comida.getId(), comida.getNome(), comida.getEmail(), comida.getEmail(), comida.getComida(), comida.getPreco());
    }
}
