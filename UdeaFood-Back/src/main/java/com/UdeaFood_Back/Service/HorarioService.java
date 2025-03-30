package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.HorarioDTO;
import com.UdeaFood_Back.Modelo.Horario;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Repository.IHorario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class HorarioService {

    private final IHorario iHorario;
    private final TiendaService tiendaService;

    public Horario consultarHorarioPorIdTienda(Integer idTienda){
        return iHorario.findByTienda_Id(idTienda);
    }

    public void crearHorario(HorarioDTO horarioDTO){

        Tienda tienda = tiendaService.getTiendaById(horarioDTO.getIdTienda());


        if(tienda == null){
            throw new IllegalArgumentException("Tienda no encontrada con id: " + horarioDTO.getIdTienda());
        }

        if(tienda.getHorario() !=null){
            iHorario.deleteById(tienda.getHorario().getId());
        }
        Horario newHorario = new Horario();
        newHorario.setHorario1(horarioDTO.getHorario1());
        newHorario.setHorario2(horarioDTO.getHorario2());
        iHorario.save(newHorario);

        tienda.setHorario(newHorario);
        tiendaService.guardarTienda(tienda);

    }

    public void borrarHorario(Integer idTienda){

    }
}
