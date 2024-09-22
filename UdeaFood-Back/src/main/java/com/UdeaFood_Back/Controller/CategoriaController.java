package com.UdeaFood_Back.Controller;


import com.UdeaFood_Back.Modelo.Categoria;
import com.UdeaFood_Back.Service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/Categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;



    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategories() {
        return ResponseEntity.ok(categoriaService.getAllCategories());
    }
}
