package com.duoc.CloudNative_s1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.duoc.CloudNative_s1.model.Usuario;
import com.duoc.CloudNative_s1.repository.UsuarioRepository;




@Service
public class UsuarioServices {

    // Repositorio inyectado por constructor
    private final UsuarioRepository usuarioRepository;

    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método Get - devuelve todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Método Get - devuelve un usuario por su ID
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Método Post - guardar un nuevo usuario
    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Método Put - modificar un usuario existente
    public Usuario modificar(Long id, Usuario usuario) {
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    // Método Delete - elimina por ID
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
    
}
