package br.com.univesp.oleodescarte.application.rest;

import br.com.univesp.oleodescarte.domain.doador.Doador;
import br.com.univesp.oleodescarte.domain.doador.DoadorService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor(onConstructor_ = @Autowired)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OleoDescarteController {

    DoadorService doadorService;

    @GetMapping("doador")
    public ResponseEntity<DoadorResponse> getDoadorByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(DoadorResponse.of(doadorService.getDoadorByEmail(email)));
    }

    @PostMapping("cadastrar")
    public ResponseEntity<DoadorResponse> registerDoador(@Valid @RequestBody DoadorRequest request) {
        return ResponseEntity.ok(DoadorResponse.of(doadorService.createNew(request)));
    }

}
