package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Horario;
import com.UdeaFood_Back.Service.HorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/horario")
@RequiredArgsConstructor
public class HorarioController {

    private final HorarioService horarioService;

    @GetMapping("/{idTienda}")
    public ResponseEntity<Horario> consultarHorarioPorIdTienda(@PathVariable Integer idTienda){
        return ResponseEntity.ok(horarioService.consultarHorarioPorIdTienda(idTienda));
    }
}
