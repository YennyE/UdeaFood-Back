package com.UdeaFood_Back.Controller;

import com.UdeaFood_Back.DTO.ProductoDTO;
import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;


    @Operation(summary = "Crear un nuevo producto", description = "Permite crear un nuevo producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El producto se creó exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/crearProducto")
    public ResponseEntity<String> crearProducto(@RequestBody ProductoDTO productoDTO) {
        productoService.crearProducto(productoDTO);

        return ResponseEntity.ok("Producto creado");
    }
    @GetMapping("/consultar/{nombre}")
    public ResponseEntity<List<Producto>> crearProducto(@PathVariable String nombre) {
        return ResponseEntity.ok(productoService.consultarPorNombre(nombre));

        //return ResponseEntity.ok("Producto creado");
    }

    @GetMapping("/obtenerTodos/{categoria}")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos(@PathVariable String categoria) {
        return ResponseEntity.ok(productoService.obtenerTodosLosProductos(categoria));
    }
    //para tipo de tieda
   // @GetMapping("/tipo-tienda/{tipoTienda}")
    //public List<Producto>obtenerProductosPorTipoTienda(@PathVariable String tipoTienda){
      //  return productoService.obtenerProductosPorTipoTienda(tipoTienda);
    //}

}
