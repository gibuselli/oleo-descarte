package br.com.univesp.oleodescarte.domain.doador;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "DOADOR")
public class Doador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOADOR")
    Long id;

    @NotBlank
    @Column(name = "NOME")
    @Size(min = 3, max = 30)
    String nome;

    @NotBlank
    @Column(name = "CIDADE")
    @Size(min = 3, max = 30)
    String cidade;

    @NotBlank
    @Column(name = "BAIRRO")
    @Size(min = 3, max = 30)
    String bairro;

    @NotBlank
    @Email
    @Column(name = "EMAIL")
    String email;

    @NonNull
    @PositiveOrZero
    @Column(name = "QNT_DE_OLEO")
    @Max(99)
    Double qntDeOleo;

    @NonNull
    @Column(name = "DOANDO")
    Boolean estaDoando;
}