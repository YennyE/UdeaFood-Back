package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository

public interface ISeccionRepository extends JpaRepository<Seccion, Integer> {

    List<Seccion> findAllByIdTienda(Integer idTienda);
}
