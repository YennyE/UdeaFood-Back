package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
    List<MetodoPago> findByTiendaId(Integer idTienda);
    void deleteByIdAndTiendaId(Integer id, Integer idTienda);
}
