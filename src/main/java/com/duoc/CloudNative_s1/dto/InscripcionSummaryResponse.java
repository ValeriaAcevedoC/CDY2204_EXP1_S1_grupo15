package com.duoc.CloudNative_s1.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InscripcionSummaryResponse {
    private Long inscripcionId;
    private Long estudianteId;
    private LocalDate fechaInscripcion;
    private List<InscripcionCourseDetail> cursos;
    private BigDecimal total;

    public InscripcionSummaryResponse() {}

    public InscripcionSummaryResponse(Long inscripcionId, Long estudianteId, LocalDate fechaInscripcion, List<InscripcionCourseDetail> cursos, BigDecimal total) {
        this.inscripcionId = inscripcionId;
        this.estudianteId = estudianteId;
        this.fechaInscripcion = fechaInscripcion;
        this.cursos = cursos;
        this.total = total;
    }

    public Long getInscripcionId() { return inscripcionId; }
    public Long getEstudianteId() { return estudianteId; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public List<InscripcionCourseDetail> getCursos() { return cursos; }
    public BigDecimal getTotal() { return total; }

    public void setInscripcionId(Long inscripcionId) { this.inscripcionId = inscripcionId; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
    public void setCursos(List<InscripcionCourseDetail> cursos) { this.cursos = cursos; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
