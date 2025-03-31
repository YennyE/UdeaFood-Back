package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.HorarioDTO;
import com.UdeaFood_Back.Modelo.Horario;
import com.UdeaFood_Back.Service.HorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HorarioController {

    private final HorarioService horarioService;




    @GetMapping("/{idTienda}")
    public ResponseEntity<Horario> consultarHorarioPorIdTienda(@PathVariable Integer idTienda){
        return ResponseEntity.ok(horarioService.consultarHorarioPorIdTienda(idTienda));
    }


    @PostMapping
    public ResponseEntity<String> crearHorario(@RequestBody HorarioDTO horarioDTO){
        horarioService.crearHorario(horarioDTO);
        return ResponseEntity.ok("Horario creado con exito");
    }
}
