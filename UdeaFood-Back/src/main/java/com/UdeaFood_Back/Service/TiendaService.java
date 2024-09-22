package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Repository.ItiendaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TiendaService {

    private final ItiendaRepository itiendaRepository;



    public void crear_tienda (Tienda tienda){
        itiendaRepository.save(tienda);
    }

}
