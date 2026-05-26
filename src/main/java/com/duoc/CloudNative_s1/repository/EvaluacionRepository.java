package com.duoc.CloudNative_s1.repository;

import com.duoc.CloudNative_s1.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repositorio JPA para la entidad Evaluacion.
 * Proporciona métodos de acceso a datos e incluye una consulta
 * personalizada para buscar evaluaciones por ID de curso.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    // Busca todas las evaluaciones asociadas a un curso específico
    List<Evaluacion> findByCursoId(Long cursoId);
}