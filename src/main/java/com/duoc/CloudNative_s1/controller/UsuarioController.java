package com.duoc.CloudNative_s1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.CloudNative_s1.model.Usuario;
import com.duoc.CloudNative_s1.services.UsuarioServices;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodos() {
        List<Usuario> usuarios = usuarioServices.obtenerTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioServices.obtenerPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        Usuario creado = usuarioServices.registrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuarioServices.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Usuario actualizado = usuarioServices.modificar(id, usuario);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (usuarioServices.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuarioServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

