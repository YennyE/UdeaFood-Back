package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
