package br.com.univesp.oleodescarte.domain.doador;

import br.com.univesp.oleodescarte.application.rest.DoadorAssembler;
import br.com.univesp.oleodescarte.application.rest.DoadorRequest;
import br.com.univesp.oleodescarte.domain.exception.DoadorCadastradoException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DoadorService {

    DoadorRepository repository;

    DoadorAssembler assembler;

    public void save(Doador doador) {
        repository.save(doador);
    }

    public void createNew(DoadorRequest request) {
        Optional<Doador> optDoador = repository.findByEmail(request.getEmail());

        optDoador.ifPresentOrElse(
                (doador) -> {
                    throw new DoadorCadastradoException();
                },
                () -> {
                    Doador doador = assembler.assemble(request);
                    save(doador);
                });
    }
}
