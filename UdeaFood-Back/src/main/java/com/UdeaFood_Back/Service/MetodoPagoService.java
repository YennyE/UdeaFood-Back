package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.MetodoPagoDTO;
import com.UdeaFood_Back.Modelo.MetodoPago;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Repository.IMetodoPagoRepository;
import com.UdeaFood_Back.Repository.ItiendaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetodoPagoService {

    private final IMetodoPagoRepository metodoPagoRepository;
    private final ItiendaRepository tiendaRepository;

    public List<MetodoPago> obtenerMetodosPorTienda(Integer idTienda) {
        return metodoPagoRepository.findByTiendaId(idTienda);
    }

    public MetodoPago agregarMetodoPago(MetodoPagoDTO metodoPagoDTO) {
        Tienda tienda = tiendaRepository.findById(metodoPagoDTO.getIdTienda())
                .orElseThrow(() -> new EntityNotFoundException("Tienda no encontrada"));

        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setTipo(metodoPagoDTO.getTipo());
        metodoPago.setDetalles(metodoPagoDTO.getDetalles());
        metodoPago.setTienda(tienda);

        return metodoPagoRepository.save(metodoPago);
    }

    public void eliminarMetodoPago(Integer idMetodo, Integer idTienda) {
        metodoPagoRepository.deleteByIdAndTiendaId(idMetodo, idTienda);
    }
}
