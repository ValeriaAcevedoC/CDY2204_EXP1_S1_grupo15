package com.duoc.CloudNative_s1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.CloudNative_s1.model.Evaluacion;
import com.duoc.CloudNative_s1.repository.EvaluacionRepository;



@Service
public class EvaluacionServices {

    // Repositorio inyectado por constructor
    private final EvaluacionRepository evaluacionRepository;
    
    public EvaluacionServices(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    // Método Get - Consultar todas las evaluaciones
    public List<Evaluacion> obtenerTodas() {
        return evaluacionRepository.findAll();
    }

    // Método Get - Consultar evaluaciones por curso
    public List<Evaluacion> obtenerEvaluacionesPorCurso(Long cursoId) {
        return evaluacionRepository.findByCursoId(cursoId);
    }   

    // Método Post - Registrar una nueva evaluación
    public Evaluacion registrar(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    // Método Put - modificar una evaluación existente
    public Evaluacion modificar(Long id, Evaluacion evaluacion) {
        evaluacion.setId(id);
        return evaluacionRepository.save(evaluacion);
    }
     
}
