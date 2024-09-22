package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Categoria;
import com.UdeaFood_Back.Repository.ICategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoriaService {

    private final ICategoriaRepository iCategoriaRepository;


    public List<Categoria> getAllCategories() {
        return iCategoriaRepository.findAll();
    }
}
