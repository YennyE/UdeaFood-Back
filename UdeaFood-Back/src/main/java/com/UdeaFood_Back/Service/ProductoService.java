package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Modelo.Tienda;
import com.UdeaFood_Back.Repository.IProductoRepository;
import com.UdeaFood_Back.Repository.ItiendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductoService {

    private IProductoRepository iProductoRepository;

    public void crearProducto(Producto producto){iProductoRepository.save(producto);}

    public ProductoService(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }
}
