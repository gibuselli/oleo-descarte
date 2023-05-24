package br.com.univesp.oleodescarte.domain.exception;

public class DoadorCadastradoException extends RuntimeException {

    private static final String MESSAGE = "Doador já cadastrado.";

    public DoadorCadastradoException() {
        super(MESSAGE);
    }
}
