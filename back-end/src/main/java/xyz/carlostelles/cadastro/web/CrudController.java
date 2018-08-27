package xyz.carlostelles.cadastro.web;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import xyz.carlostelles.cadastro.business.service.GenericService;
import xyz.carlostelles.cadastro.business.validation.ValidationSuite;
import xyz.carlostelles.cadastro.web.converter.Converter;


public class CrudController<E, B, C extends Converter<E, B>, R extends CrudRepository<E, Long>, V extends ValidationSuite<E>, S extends GenericService<E, R, V>> {

    private final S service;
    private final C converter;

    public CrudController(S service, C converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody B viewBean) {
        E entity = converter.decode(viewBean);
        E response = this.service.create(entity);
        viewBean = converter.encode(response);
        return new ResponseEntity<>(viewBean, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody B viewBean) {
        E entity = converter.decode(viewBean);
        E response = this.service.update(entity);
        viewBean = converter.encode(response);
        return new ResponseEntity<>(viewBean, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        E entity = this.service.get(id);
        this.service.delete(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Long id) {
        E response = this.service.get(id);
        B viewBean = converter.encode(response);
        return new ResponseEntity<>(viewBean, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<E> response = this.service.get();
        List<B> viewBean = converter.encodeAll(response);
        return new ResponseEntity<>(viewBean, HttpStatus.OK);
    }
}
