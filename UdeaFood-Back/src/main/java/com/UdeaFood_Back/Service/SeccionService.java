package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Repository.ISeccionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SeccionService {

    private final ISeccionRepository iSeccionRepository;



    public void crearSeccion(Seccion seccion){
        iSeccionRepository.save(seccion);
    }



    public List<Seccion> getAllSeccionesByIdTienda(Integer idTienda){
        return iSeccionRepository.findAllByIdTienda(idTienda);
    };
}
