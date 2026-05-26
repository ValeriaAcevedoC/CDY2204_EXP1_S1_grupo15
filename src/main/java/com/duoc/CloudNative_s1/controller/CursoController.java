package com.duoc.CloudNative_s1.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.duoc.CloudNative_s1.model.Curso;
import com.duoc.CloudNative_s1.services.CursoServices;
import com.duoc.CloudNative_s1.dto.CreateCursoRequest;
import com.duoc.CloudNative_s1.dto.CursoResponse;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoServices cursoServices;

    public CursoController(CursoServices cursoServices) {
        this.cursoServices = cursoServices;
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> obtenerTodos() {
        List<Curso> cursos = cursoServices.obtenerTodos();
        List<CursoResponse> resp = cursos.stream()
                .map(c -> new CursoResponse(c.getId(), c.getNombre(), c.getInstructor(), c.getDuracionHoras(), c.getCosto()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> obtenerPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoServices.obtenerPorId(id);
        return curso.map(c -> ResponseEntity.ok(new CursoResponse(c.getId(), c.getNombre(), c.getInstructor(), c.getDuracionHoras(), c.getCosto())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CursoResponse> registrar(@RequestBody CreateCursoRequest req) {
        Curso curso = new Curso();
        curso.setNombre(req.getNombre());
        curso.setDescripcion(req.getDescripcion());
        curso.setInstructor(req.getInstructor());
        curso.setDuracionHoras(req.getDuracionHoras());
        curso.setCosto(req.getCosto());
        Curso creado = cursoServices.registrar(curso);
        CursoResponse resp = new CursoResponse(creado.getId(), creado.getNombre(), creado.getInstructor(), creado.getDuracionHoras(), creado.getCosto());
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> modificar(@PathVariable Long id, @RequestBody CreateCursoRequest req) {
        Optional<Curso> existing = cursoServices.obtenerPorId(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Curso curso = existing.get();
        curso.setNombre(req.getNombre());
        curso.setDescripcion(req.getDescripcion());
        curso.setInstructor(req.getInstructor());
        curso.setDuracionHoras(req.getDuracionHoras());
        curso.setCosto(req.getCosto());
        Curso actualizado = cursoServices.modificar(id, curso);
        CursoResponse resp = new CursoResponse(actualizado.getId(), actualizado.getNombre(), actualizado.getInstructor(), actualizado.getDuracionHoras(), actualizado.getCosto());
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (cursoServices.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cursoServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

