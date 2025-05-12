package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.CalificacionRequest;
import com.UdeaFood_Back.Modelo.Calificacion;
import com.UdeaFood_Back.Service.CalificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calificacion")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalificacionController {

    private final CalificacionService calificacionService;


    public List<Calificacion> getCalificaciones(Integer idProducto){
        return calificacionService.getCalificaciones(idProducto);
    }

    public void calificar(CalificacionRequest calificacionRequest){
        calificacionService.calificar(calificacionRequest);
    }
}
