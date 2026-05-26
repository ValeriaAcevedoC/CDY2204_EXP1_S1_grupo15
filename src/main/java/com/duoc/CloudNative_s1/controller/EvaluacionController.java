package com.duoc.CloudNative_s1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.CloudNative_s1.model.Evaluacion;
import com.duoc.CloudNative_s1.services.EvaluacionServices;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionServices evaluacionServices;

    public EvaluacionController(EvaluacionServices evaluacionServices) {
        this.evaluacionServices = evaluacionServices;
    }

    @GetMapping
    public ResponseEntity<List<Evaluacion>> obtenerTodas() {
        return ResponseEntity.ok(evaluacionServices.obtenerTodas());
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Evaluacion>> obtenerPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(evaluacionServices.obtenerEvaluacionesPorCurso(cursoId));
    }

    @PostMapping
    public ResponseEntity<Evaluacion> registrar(@RequestBody Evaluacion evaluacion) {
        Evaluacion creado = evaluacionServices.registrar(evaluacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluacion> modificar(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        Evaluacion actualizado = evaluacionServices.modificar(id, evaluacion);
        return ResponseEntity.ok(actualizado);
    }
}

