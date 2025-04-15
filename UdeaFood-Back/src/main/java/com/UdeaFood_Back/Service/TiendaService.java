package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.TiendaRequest;
import com.UdeaFood_Back.Modelo.Seccion;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Modelo.TipoTienda;
import com.UdeaFood_Back.Repository.ISeccionRepository;
import com.UdeaFood_Back.Repository.ItiendaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TiendaService {

    private final ItiendaRepository itiendaRepository;
    private final ISeccionRepository iSeccionRepository;



    public void crear_tienda (TiendaRequest tiendaRequest){

        Tienda tienda = mapToTienda(tiendaRequest);
        itiendaRepository.save(tienda);

        Seccion seccion = new Seccion();
        seccion.setIdTienda(tienda);
        seccion.setNombre("Productos");
        seccion.setProductos(Collections.emptyList());
        iSeccionRepository.save(seccion);
    }


    // Convierte un objeto de tipo TiendaRequest a un objeto de tipo Tienda
    private Tienda mapToTienda(TiendaRequest tiendaRequest) {
        Tienda tienda = new Tienda();
        tienda.setNombre(tiendaRequest.getNombre());
        tienda.setDescripcion(tiendaRequest.getDescripcion());
        tienda.setUbicacion(tiendaRequest.getUbicacion());
        tienda.setFoto(tiendaRequest.getFoto());
        tienda.setCorreo(tiendaRequest.getCorreo());
        tienda.setUsuario(tiendaRequest.getUsuario());
        tienda.setClave(tiendaRequest.getClave());
        tienda.setDomicilio(tiendaRequest.getDomicilio());
        tienda.setContacto(tiendaRequest.getContacto());
        tienda.setTipoTienda(tiendaRequest.getTipoTienda());

        tienda.setCalificacion(0.0F);
        tienda.setNumeroCalificaciones(0);
        return tienda;
    }




    // Obtener tiendas por tipo de tienda
    public List<Tienda> getTiendasByTipoTienda(TipoTienda tipoTienda){
        return itiendaRepository.findByTipoTienda(tipoTienda);
    }


    // Obtener todas las tiendas
   public List<Tienda> getAllTiendas(){
        return itiendaRepository.findAll();
    }

    public Tienda getTiendaById(Integer id) {
        return itiendaRepository.findById(id).orElse(null);
    }

    public void guardarTienda(Tienda tienda){
        itiendaRepository.save(tienda);
    }

    public void borrarHorario(Integer idTienda){
        Tienda tienda = itiendaRepository.findById(idTienda)
                .orElseThrow(() -> new EntityNotFoundException("Tienda no encontrada"));

        tienda.setHorario(null);
        itiendaRepository.save(tienda);
    }
    public void actualizarTienda(Integer id, TiendaRequest tiendaRequest){
        Tienda tienda = itiendaRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Tienda no encontrada"));

        tienda.setNombre(tiendaRequest.getNombre());
        tienda.setDescripcion(tiendaRequest.getDescripcion());
        tienda.setUbicacion(tiendaRequest.getUbicacion());
        tienda.setFoto(tiendaRequest.getFoto());
        tienda.setCorreo(tiendaRequest.getCorreo());
        tienda.setUsuario(tiendaRequest.getUsuario());
        tienda.setClave(tiendaRequest.getClave());
        tienda.setDomicilio(tiendaRequest.getDomicilio());
        tienda.setContacto(tiendaRequest.getContacto());
        tienda.setTipoTienda(tiendaRequest.getTipoTienda());

        itiendaRepository.save(tienda);

    }

}
