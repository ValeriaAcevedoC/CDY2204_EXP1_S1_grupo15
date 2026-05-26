package com.duoc.CloudNative_s1.repository;

import com.duoc.CloudNative_s1.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    @Query("select i from Inscripcion i join i.items it where it.cursoId = :cursoId")
    List<Inscripcion> findByCursoId(@Param("cursoId") Long cursoId);

}