package br.com.univesp.oleodescarte.application.rest;

import br.com.univesp.oleodescarte.domain.doador.Doador;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DoadorAssembler {

    public Doador assemble(DoadorRequest request) {
        return Doador.builder()
                .nome(request.getNome())
                .cidade(request.getCidade())
                .bairro(request.getBairro())
                .email(request.getEmail())
                .qntDeOleo(request.getQntDeOleo())
                .build();
    }
}
