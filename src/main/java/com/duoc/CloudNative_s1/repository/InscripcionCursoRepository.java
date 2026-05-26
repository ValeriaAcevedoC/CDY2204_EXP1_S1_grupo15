package com.duoc.CloudNative_s1.repository;

import com.duoc.CloudNative_s1.model.InscripcionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionCursoRepository extends JpaRepository<InscripcionCurso, Long> {
}
