package br.com.univesp.oleodescarte.infrastructure.exception;

public class DoadorNaoEncontradoException extends RuntimeException {

    private static final String MESSAGE = "Usuário não encontrado.";

    public DoadorNaoEncontradoException() {
        super(MESSAGE);
    }
}