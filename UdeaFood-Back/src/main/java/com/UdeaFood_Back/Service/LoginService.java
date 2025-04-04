package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.LoginRequest;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Repository.ItiendaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    private final ItiendaRepository itiendaRepository;

    public Tienda login(LoginRequest loginRequest) {
        Tienda tienda = itiendaRepository.findTiendaByCorreo(loginRequest.getCorreo());

        if(Objects.equals(tienda.getClave(), loginRequest.getClave())){
            return tienda;
        }
        else{
            return null;
        }
    }
}
