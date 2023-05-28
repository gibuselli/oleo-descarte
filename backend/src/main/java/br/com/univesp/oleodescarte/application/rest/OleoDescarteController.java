package br.com.univesp.oleodescarte.application.rest;

import br.com.univesp.oleodescarte.domain.doador.Doador;
import br.com.univesp.oleodescarte.domain.doador.DoadorService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Validated
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OleoDescarteController {

    DoadorService doadorService;

    Logger log = LoggerFactory.getLogger(OleoDescarteController.class);

    @GetMapping("doador")
    public ResponseEntity<DoadorResponse> getDoadorByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(DoadorResponse.of(doadorService.getDoadorByEmail(email)));
    }

    @PostMapping("cadastrar")
    public ResponseEntity<DoadorResponse> registerDoador(@Valid @RequestBody DoadorRequest request) {
        return ResponseEntity.ok(DoadorResponse.of(doadorService.createNew(request)));
    }

    @PutMapping("atualizarCadastro")
    public ResponseEntity<DoadorResponse> updateDoador(@Valid @RequestBody DoadorRequest request) {
        return ResponseEntity.ok(DoadorResponse.of(doadorService.update(request)));
    }

    @DeleteMapping("deletarUsuario")
    public ResponseEntity deleteDoador(@Valid @RequestBody DoadorDeleteRequest request) {
        log.info("deletando usuário: " + request.getEmail());
        doadorService.delete(request.getEmail());
        return ResponseEntity.noContent().build();
    }
}
