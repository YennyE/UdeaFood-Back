package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.SeccionDTO;
import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Modelo.TipoTienda;
import com.UdeaFood_Back.Repository.ISeccionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SeccionService {

    private final ISeccionRepository iSeccionRepository;



    public void crearSeccion(SeccionDTO seccionDTO){
        Seccion seccion = new Seccion();
        seccion.setNombre(seccionDTO.getNombre());
        Tienda tienda = new Tienda();
        tienda.setId(seccionDTO.getIdTienda());
        seccion.setIdTienda(tienda);
        iSeccionRepository.save(seccion);
    }



    public List<Seccion> getAllSeccionesByIdTienda(Integer idTienda){
        Tienda tienda = new Tienda();
        tienda.setId(idTienda);
        return iSeccionRepository.findAllByIdTienda(tienda);
    };



    public List<Seccion> getAllSeccionesByTipoTienda(String tipoTienda, String palabra){

        // Guardará las secciones obtenidas de la base de datos
        List<Seccion> listaSecciones;

        // Guardará las secciones que tenga los productos que contengan la palabra buscada
        List<Seccion> listaSeccionesFiltradas = new ArrayList<>();

        if(tipoTienda.equalsIgnoreCase("formal")){
            listaSecciones =  iSeccionRepository.findAllProductByTipoTienda(TipoTienda.FORMAL);

        }else if(tipoTienda.equalsIgnoreCase("informal")){
            listaSecciones =  iSeccionRepository.findAllProductByTipoTienda(TipoTienda.INFORMAL);

        } else if (tipoTienda.equalsIgnoreCase("todas")){
            listaSecciones =  iSeccionRepository.findAll();//Obtiene todas las secciones con sus productos

        } else {
            return null;

        }

        for(Seccion s: listaSecciones){
            List<Producto> productos = new ArrayList<>();
            for(Producto p: s.getProductos()){
                if(p.getNombre().toLowerCase().contains(palabra.toLowerCase())){
                    productos.add(p);
                }
            }
            s.setProductos(productos);
            if(!s.getProductos().isEmpty()){
                listaSeccionesFiltradas.add(s);
            }
        }
        return listaSeccionesFiltradas;

    };
}
