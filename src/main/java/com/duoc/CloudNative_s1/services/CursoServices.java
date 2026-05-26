package com.duoc.CloudNative_s1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duoc.CloudNative_s1.model.Curso;
import com.duoc.CloudNative_s1.repository.CursoRepository;


@Service
public class CursoServices {

    // Repositorio inyectado por constructor
    private final CursoRepository cursoRepository;


    public CursoServices(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    //Método Get - devuelve todos los cursos
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    // Método Get - devuelve un curso por su ID
    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    //Método Post - guardar un nuevo curso
    public Curso registrar(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Método Put - modificar un curso existente
    public Curso modificar(Long id, Curso curso) {
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    // Método Delete - elimina por ID
    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
    
}