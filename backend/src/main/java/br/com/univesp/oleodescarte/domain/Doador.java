package br.com.univesp.oleodescarte.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "DOADOR")
public class Doador {

    @NotBlank
    @Column(name = "NOME")
    @Size(min = 3, max = 30)
    private String nome;

    @NotBlank
    @Column(name = "CIDADE")
    @Size(min = 3, max = 30)
    private String cidade;

    @NotBlank
    @Column(name = "BAIRRO")
    @Size(min = 3, max = 30)
    private String bairro;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name = "TELEFONE")
    private String telefone;

    @NotBlank
    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @PositiveOrZero
    @Column(name = "QNT_DE_OLEO")
    @Max(99)
    private Double qntDeOleo;

    @NotNull
    @Column(name = "DOANDO")
    private boolean estaDoando;
}
