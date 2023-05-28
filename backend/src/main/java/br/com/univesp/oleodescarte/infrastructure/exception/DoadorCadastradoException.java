package br.com.univesp.oleodescarte.infrastructure.exception;

public class DoadorCadastradoException extends RuntimeException {

    private static final String MESSAGE = "Usuário já cadastrado.";

    public DoadorCadastradoException() {
        super(MESSAGE);
    }
}
