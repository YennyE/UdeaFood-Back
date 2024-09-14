package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItiendaRepository extends JpaRepository<Tienda, Integer> {
}
