package br.com.univesp.oleodescarte.application.rest;

import br.com.univesp.oleodescarte.domain.doador.Doador;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
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
