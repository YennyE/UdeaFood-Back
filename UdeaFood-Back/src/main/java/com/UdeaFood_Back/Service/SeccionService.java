package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Repository.IProductoRepository;
import com.UdeaFood_Back.Repository.ISeccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SeccionService {
    private ISeccionRepository iSeccionRepository;

    public void crearSeccion(Seccion seccion){iSeccionRepository.save(seccion);}

    public List<Seccion> getAllSeccionByIdTienda(Integer idTienda){
        return iSeccionRepository.findAllByIdTienda(idTienda);
    };

    public SeccionService(ISeccionRepository iSeccionRepository) {
        this.iSeccionRepository = iSeccionRepository;
    }
}
