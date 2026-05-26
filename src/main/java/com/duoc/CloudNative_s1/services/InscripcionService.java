package com.duoc.CloudNative_s1.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.duoc.CloudNative_s1.dto.InscripcionCourseDetail;
import com.duoc.CloudNative_s1.dto.InscripcionRequest;
import com.duoc.CloudNative_s1.dto.InscripcionSummaryResponse;
import com.duoc.CloudNative_s1.model.Inscripcion;
import com.duoc.CloudNative_s1.model.InscripcionCurso;
import com.duoc.CloudNative_s1.model.Curso;
import com.duoc.CloudNative_s1.repository.CursoRepository;
import com.duoc.CloudNative_s1.repository.InscripcionRepository;



@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final CursoRepository cursoRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository, CursoRepository cursoRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.cursoRepository = cursoRepository;
    }

    // Consultar inscripciones por curso (usa la relación items)
    public List<Inscripcion> obtenerInscripcionesPorCurso(Long cursoId) {
        return inscripcionRepository.findByCursoId(cursoId);
    }

    // Registrar una inscripción para uno o más cursos
    @Transactional
    public InscripcionSummaryResponse registrar(InscripcionRequest req) {
        // validar lista
        if (req.getCursoIds() == null || req.getCursoIds().isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar al menos un curso");
        }

        List<Curso> cursos = cursoRepository.findAllById(req.getCursoIds());
        if (cursos.size() != req.getCursoIds().size()) {
            throw new IllegalArgumentException("Alguno de los cursos solicitados no existe");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudianteId(req.getEstudianteId());
        inscripcion.setFechaInscripcion(LocalDate.now());

        List<InscripcionCourseDetail> detalles = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (Curso c : cursos) {
            InscripcionCurso item = new InscripcionCurso();
            item.setCursoId(c.getId());
            item.setNombreCurso(c.getNombre());
            item.setCosto(c.getCosto());
            inscripcion.addItem(item);

            detalles.add(new InscripcionCourseDetail(c.getId(), c.getNombre(), c.getCosto()));
            total = total.add(c.getCosto() == null ? BigDecimal.ZERO : c.getCosto());
        }

        Inscripcion guardada = inscripcionRepository.save(inscripcion);

        return new InscripcionSummaryResponse(guardada.getId(), guardada.getEstudianteId(), guardada.getFechaInscripcion(), detalles, total);
    }

    public void eliminar(Long id) {
        inscripcionRepository.deleteById(id);
    }

}

