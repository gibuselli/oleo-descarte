package br.com.univesp.oleodescarte.infrastructure;

import br.com.univesp.oleodescarte.infrastructure.exception.DoadorCadastradoException;
import br.com.univesp.oleodescarte.infrastructure.exception.DoadorNaoEncontradoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    static final String DETALHE_DO_ERRO = "detalhes";
    static final String ERROS_DE_VALIDACAO = "erros na validação dos campos";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        final var errorResponseBuilder = CustomErrorResponse.builder();
        Map<String, String> erros = new HashMap<>();

        errorResponseBuilder.mensagem(ERROS_DE_VALIDACAO);

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            erros.put(fieldName, errorMessage);
        });

        errorResponseBuilder.erros(erros);
        return ResponseEntity.status(status).body(erros);
    }

    @ExceptionHandler({DoadorCadastradoException.class, DoadorNaoEncontradoException.class})
    protected ResponseEntity<CustomErrorResponse> doadorExceptionsHandler(
            final RuntimeException exception) {

        final var response = CustomErrorResponse.builder()
                .mensagem(exception.getMessage())
                .erro(DETALHE_DO_ERRO, exception.getMessage())
                .build();

        return ResponseEntity.status(400).body(response);
    }

}
