package br.com.univesp.oleodescarte.application.rest;

import br.com.univesp.oleodescarte.domain.doador.Doador;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class DoadorResponse {
    String nome;
    String cidade;
    String bairro;
    String email;
    Double qntDeOleo;

    public static DoadorResponse of(Doador doador) {
        return DoadorResponse.builder()
                .nome(doador.getNome())
                .cidade(doador.getCidade())
                .bairro(doador.getBairro())
                .email(doador.getEmail())
                .qntDeOleo(doador.getQntDeOleo())
                .build();
    }
}
