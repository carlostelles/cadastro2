package xyz.carlostelles.cadastro.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.carlostelles.cadastro.business.data.Risco;

@Component
@RestController
@CrossOrigin
@RequestMapping(value = "/utils")
public class UtilsController {

    @GetMapping(value = "/risco")
    public ResponseEntity<?> getRisco() {
        return new ResponseEntity<>(Risco.values(), HttpStatus.OK);
    }

}