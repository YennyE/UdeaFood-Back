package com.UdeaFood_Back.Controller;


import com.UdeaFood_Back.DTO.CalificacionRequest;
import com.UdeaFood_Back.DTO.CalificacionResponse;
import com.UdeaFood_Back.Service.CalificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificacion")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalificacionController {

    private final CalificacionService calificacionService;


    @GetMapping("/{idProducto}")
    public List<CalificacionResponse> getCalificaciones(@PathVariable Integer idProducto){
        return calificacionService.getCalificaciones(idProducto);
    }

    @PostMapping()
    public CalificacionResponse calificar(@RequestBody CalificacionRequest calificacionRequest){
        return calificacionService.calificar(calificacionRequest);
    }
}
