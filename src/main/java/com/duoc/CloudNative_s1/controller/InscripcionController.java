package com.duoc.CloudNative_s1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.CloudNative_s1.dto.InscripcionRequest;
import com.duoc.CloudNative_s1.dto.InscripcionSummaryResponse;
import com.duoc.CloudNative_s1.model.Inscripcion;
import com.duoc.CloudNative_s1.services.InscripcionService;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Inscripcion>> obtenerPorCurso(@PathVariable("cursoId") Long cursoId) {
        return ResponseEntity.ok(inscripcionService.obtenerInscripcionesPorCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<InscripcionSummaryResponse> registrar(@RequestBody InscripcionRequest req) {
        InscripcionSummaryResponse creado = inscripcionService.registrar(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        inscripcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

