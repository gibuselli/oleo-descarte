package br.com.univesp.oleodescarte.domain.exception;

public class DoadorNaoEncontradoException extends RuntimeException {

    private static final String MESSAGE = "Usuário não encontrado.";

    public DoadorNaoEncontradoException() {
        super(MESSAGE);
    }
}