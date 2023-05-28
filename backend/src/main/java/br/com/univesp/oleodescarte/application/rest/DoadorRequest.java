package br.com.univesp.oleodescarte.application.rest;

import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor(force = true)
public class DoadorRequest {

    @NotBlank
    @Size(min = 3, max = 30)
    String nome;

    @NotBlank
    @Size(min = 3, max = 30)
    String cidade;

    @NotBlank
    @Size(min = 3, max = 30)
    String bairro;

    @NotBlank
    @Email
    String email;

    @NonNull
    @PositiveOrZero
    @Max(99)
    Double qntDeOleo;
}
