package com.duoc.CloudNative_s1.dto;

import java.math.BigDecimal;

public class CursoResponse {
    private Long id;
    private String nombre;
    private String instructor;
    private Integer duracionHoras;
    private BigDecimal costo;

    public CursoResponse() {}

    public CursoResponse(Long id, String nombre, String instructor, Integer duracionHoras, BigDecimal costo) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.duracionHoras = duracionHoras;
        this.costo = costo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getInstructor() { return instructor; }
    public Integer getDuracionHoras() { return duracionHoras; }
    public BigDecimal getCosto() { return costo; }

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setDuracionHoras(Integer duracionHoras) { this.duracionHoras = duracionHoras; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
}
