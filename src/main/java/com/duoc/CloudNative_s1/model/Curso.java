package com.duoc.CloudNative_s1.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase modelo que representa un curso dentro de la plataforma de aprendizaje.
 * Define la estructura de datos de un curso, incluyendo su identificador,
 * nombre, descripción y el ID del profesor que lo imparte.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String instructor;
    private Integer duracionHoras;
    private BigDecimal costo;
    private Long profesorId;

    public Curso() {}

    public Curso(Long id, String nombre, String descripcion, String instructor, Integer duracionHoras, BigDecimal costo, Long profesorId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.instructor = instructor;
        this.duracionHoras = duracionHoras;
        this.costo = costo;
        this.profesorId = profesorId;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getInstructor() { return instructor; }
    public Integer getDuracionHoras() { return duracionHoras; }
    public BigDecimal getCosto() { return costo; }
    public Long getProfesorId() { return profesorId; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setDuracionHoras(Integer duracionHoras) { this.duracionHoras = duracionHoras; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
    public void setProfesorId(Long profesorId) { this.profesorId = profesorId; }
}