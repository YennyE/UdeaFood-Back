package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Repository.ItiendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TiendaService {
    private ItiendaRepository itiendaRepository;

    public void crear_tienda (Tienda tienda){
        itiendaRepository.save(tienda);
    }

    public TiendaService(ItiendaRepository itiendaRepository) {
        this.itiendaRepository = itiendaRepository;
    }
}
