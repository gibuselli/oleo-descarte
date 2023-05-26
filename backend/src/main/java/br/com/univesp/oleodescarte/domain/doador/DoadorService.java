package br.com.univesp.oleodescarte.domain.doador;

import br.com.univesp.oleodescarte.application.rest.DoadorRequest;
import br.com.univesp.oleodescarte.domain.exception.DoadorCadastradoException;
import br.com.univesp.oleodescarte.domain.exception.DoadorNaoEncontradoException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DoadorService {

    DoadorRepository repository;

    public Doador save(Doador doador) {
        return repository.save(doador);
    }

    @Transactional(rollbackFor = Exception.class)
    public Doador createNew(@NonNull final DoadorRequest request) {
        Optional<Doador> optDoador = repository.findByEmail(request.getEmail());

        if (optDoador.isPresent()) {
            throw new DoadorCadastradoException();
        }

        return save(Doador.of(request));
    }

    public Doador getDoadorByEmail(@NonNull final String email) {
        Optional<Doador> optDoador = repository.findByEmail(email);

        if (optDoador.isEmpty()) {
            throw new DoadorNaoEncontradoException();
        }

        return optDoador.get();
    }
}
