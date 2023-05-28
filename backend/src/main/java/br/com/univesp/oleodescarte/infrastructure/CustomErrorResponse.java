package br.com.univesp.oleodescarte.infrastructure;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Builder
@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class CustomErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1241497353828664135L;

    String mensagem;

    @Singular Map<String, String> erros;
}
