package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.Modelo.Usuario;
import com.UdeaFood_Back.Service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Crear un nuevo usuario", description = "Permite crear un nuevo usuario en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/crearUsuario")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario newUsuario) {
        try {
            usuarioService.crearUsuario(newUsuario);
            return ResponseEntity.ok("Usuario creado exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body("Error al crear el usuario: " + e.getMessage());
        }
    }
}
