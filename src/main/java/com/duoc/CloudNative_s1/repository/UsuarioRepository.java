package com.duoc.CloudNative_s1.repository;

import com.duoc.CloudNative_s1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad Usuario.
 * Proporciona automáticamente los métodos de acceso a datos
 * como guardar, buscar, listar y eliminar usuarios.
 *
 * @author Valeria Acevedo & Rafael Navarrete
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}