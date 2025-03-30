package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Horario;
import com.UdeaFood_Back.Repository.IHorario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class HorarioService {

    private final IHorario iHorario;

    public Horario consultarHorarioPorIdTienda(Integer idTienda){
        return iHorario.findByTienda_Id(idTienda);
    }
}
