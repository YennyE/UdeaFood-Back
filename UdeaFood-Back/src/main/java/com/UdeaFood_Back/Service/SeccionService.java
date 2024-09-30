package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Modelo.TipoTienda;
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
        Tienda tienda = new Tienda();
        tienda.setId(idTienda);
        return iSeccionRepository.findAllByIdTienda(tienda);
    };



    public List<Seccion> getAllSeccionesByTipoTienda(String tipoTienda){

        if(tipoTienda.equalsIgnoreCase("formal")){
            return iSeccionRepository.findAllProductByTipoTienda(TipoTienda.FORMAL);
        }else if(tipoTienda.equalsIgnoreCase("informal")){
            return iSeccionRepository.findAllProductByTipoTienda(TipoTienda.INFORMAL);
        }else{
            return null;
        }

    };
}
