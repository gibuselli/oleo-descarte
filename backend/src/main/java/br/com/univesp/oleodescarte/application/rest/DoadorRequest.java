package br.com.univesp.oleodescarte.application.rest;

import lombok.Data;

@Data
public class DoadorRequest {
    String nome;
    String cidade;
    String bairro;
    String email;
    Double qntDeOleo;
}
