package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorario extends JpaRepository<Horario, Integer> {

    Horario findByTienda_Id(Integer idTienda);
}
