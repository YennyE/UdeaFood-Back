package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsUsuarioByCorreo(String correo);
}
