package com.UdeaFood_Back.Repository;

import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Modelo.TipoTienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItiendaRepository extends JpaRepository<Tienda, Integer> {

    //Método para obtener tiendas por tipo de tienda
    List<Tienda> findByTipoTienda(TipoTienda tipoTienda);

    Tienda findTiendaByCorreo(String correo);

}
