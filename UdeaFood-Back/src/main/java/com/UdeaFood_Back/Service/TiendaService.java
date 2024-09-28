package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Repository.ISeccionRepository;
import com.UdeaFood_Back.Repository.ItiendaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class TiendaService {

    private final ItiendaRepository itiendaRepository;
    private final ISeccionRepository iSeccionRepository;



    public void crear_tienda (Tienda tienda){itiendaRepository.save(tienda);

        Seccion seccion = new Seccion();
        seccion.setIdTienda(tienda.getId());
        seccion.setNombre("Productos");
        seccion.setProductos(Collections.emptyList());
        iSeccionRepository.save(seccion);
    }

}
