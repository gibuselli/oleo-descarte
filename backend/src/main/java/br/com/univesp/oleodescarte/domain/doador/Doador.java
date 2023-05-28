package br.com.univesp.oleodescarte.domain.doador;

import br.com.univesp.oleodescarte.application.rest.DoadorRequest;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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

    @Setter
    @Column(name = "DOANDO")
    Boolean estaDoando;

    public static Doador of(DoadorRequest request) {
        return Doador.builder()
                .nome(request.getNome())
                .cidade(request.getCidade())
                .bairro(request.getBairro())
                .email(request.getEmail())
                .qntDeOleo(request.getQntDeOleo())
                .estaDoando(true)
                .build();
    }

    public static Doador of(DoadorRequest request, Long id) {
        return Doador.builder()
                .id(id)
                .nome(request.getNome())
                .cidade(request.getCidade())
                .bairro(request.getBairro())
                .email(request.getEmail())
                .qntDeOleo(request.getQntDeOleo())
                .estaDoando(true)
                .build();
    }
}
