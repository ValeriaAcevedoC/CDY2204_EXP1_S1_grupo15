package com.duoc.CloudNative_s1.dto;

import java.math.BigDecimal;

public class CreateCursoRequest {
    private String nombre;
    private String descripcion;
    private String instructor;
    private Integer duracionHoras;
    private BigDecimal costo;

    public CreateCursoRequest() {}

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getInstructor() { return instructor; }
    public Integer getDuracionHoras() { return duracionHoras; }
    public BigDecimal getCosto() { return costo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setDuracionHoras(Integer duracionHoras) { this.duracionHoras = duracionHoras; }
    public void setCosto(BigDecimal costo) { this.costo = costo; }
}
