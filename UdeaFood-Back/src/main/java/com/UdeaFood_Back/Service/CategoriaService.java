package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Categoria;
import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Repository.ICategoriaRepository;
import com.UdeaFood_Back.Repository.IProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoriaService {

    private ICategoriaRepository iCategoriaRepository;



    public CategoriaService(ICategoriaRepository iCategoriaRepository) {
        this.iCategoriaRepository = iCategoriaRepository;
    }



    public List<Categoria> getAllCategories() {
        return iCategoriaRepository.findAll();
    }
}
