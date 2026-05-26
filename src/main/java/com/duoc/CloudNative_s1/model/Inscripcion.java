package com.duoc.CloudNative_s1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Clase modelo que representa una inscripción de un estudiante a uno o más cursos
 * dentro de la plataforma de aprendizaje. Contiene el identificador del estudiante,
 * la fecha de inscripción y la lista de ítems (cursos) inscritos.
 */

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long estudianteId;
    private LocalDate fechaInscripcion;

    @OneToMany(mappedBy = "inscripcion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InscripcionCurso> items = new ArrayList<>();

    public Inscripcion() {}

    public Inscripcion(Long id, Long estudianteId, LocalDate fechaInscripcion, List<InscripcionCurso> items) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.fechaInscripcion = fechaInscripcion;
        this.items = items != null ? items : new ArrayList<>();
    }

    public Long getId() { return id; }
    public Long getEstudianteId() { return estudianteId; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public List<InscripcionCurso> getItems() { return items; }

    public void setId(Long id) { this.id = id; }
    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
    public void setItems(List<InscripcionCurso> items) { this.items = items; }

    public void addItem(InscripcionCurso item) {
        items.add(item);
        item.setInscripcion(this);
    }

    public void removeItem(InscripcionCurso item) {
        items.remove(item);
        item.setInscripcion(null);
    }
}