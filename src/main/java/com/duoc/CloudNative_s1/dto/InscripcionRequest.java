package com.duoc.CloudNative_s1.dto;

import java.util.List;

public class InscripcionRequest {
    private Long estudianteId;
    private List<Long> cursoIds;

    public InscripcionRequest() {}

    public Long getEstudianteId() { return estudianteId; }
    public List<Long> getCursoIds() { return cursoIds; }

    public void setEstudianteId(Long estudianteId) { this.estudianteId = estudianteId; }
    public void setCursoIds(List<Long> cursoIds) { this.cursoIds = cursoIds; }
}
