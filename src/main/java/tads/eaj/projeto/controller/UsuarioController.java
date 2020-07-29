package tads.eaj.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.projeto.model.Usuario;
import tads.eaj.projeto.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")
public class UsuarioController {
    private UsuarioService service;

    @Autowired
    public void setService(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listAll(){
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> getOne(@PathVariable Long id){

        return service
                .findById(id)
                .map(
                        record -> ResponseEntity.ok().body(record)
                ).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario insert(@RequestBody Usuario u){
        return service.insert(u);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario u){
        return service
                .findById(id)
                .map( record -> {
                    service.saveAndFlush(u);
                    return ResponseEntity.ok().body(u);

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id)
                .map( record -> {
                    service.delete(id);
                    return ResponseEntity.ok().build();

                }).orElse(ResponseEntity.notFound().build());
    }

}