package br.com.univesp.oleodescarte.application.rest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
public class DoadorDeleteRequest {
    @NotBlank
    @Email
    String email;
}
