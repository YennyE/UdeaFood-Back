package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Repository.IProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoService {

    private final IProductoRepository iProductoRepository;



    public void crearProducto(Producto producto){
        iProductoRepository.save(producto);
    }

}
