package com.duoc.CloudNative_s1.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscripcion_curso")
public class InscripcionCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id")
    private Inscripcion inscripcion;

    private Long cursoId;
    private String nombreCurso;
    private BigDecimal costo;

    public InscripcionCurso() {}

    public InscripcionCurso(Long id, Long cursoId, String nombreCurso, BigDecimal costo) {
        this.id = id;
        this.cursoId = cursoId;
        this.nombreCurso = nombreCurso;
        this.costo = costo;
    }

    public Long getId() { return id; }
    public Inscripcion getInscripcion() { return inscripcion; }
    public Long getCursoId() { return cursoId; }
    public String getNombreCurso() { return nombreCurso; }
    public BigDecimal getCosto() { return costo; }

    public void setId(Long id) { this.id = id; }
    public void setInscripcion(Inscripcion inscripcion) { this.inscripcion = inscripcion; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
}
