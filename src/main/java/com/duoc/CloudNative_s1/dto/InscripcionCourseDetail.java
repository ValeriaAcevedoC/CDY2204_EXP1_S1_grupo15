package com.duoc.CloudNative_s1.dto;

import java.math.BigDecimal;

public class InscripcionCourseDetail {
    private Long cursoId;
    private String nombre;
    private BigDecimal costo;

    public InscripcionCourseDetail() {}

    public InscripcionCourseDetail(Long cursoId, String nombre, BigDecimal costo) {
        this.cursoId = cursoId;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Long getCursoId() { return cursoId; }
    public String getNombre() { return nombre; }
    public BigDecimal getCosto() { return costo; }

    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
}
