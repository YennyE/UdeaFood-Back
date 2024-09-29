package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.Modelo.Categoria;
import com.UdeaFood_Back.Modelo.Producto;
import com.UdeaFood_Back.Repository.IProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductoService {

    private final IProductoRepository iProductoRepository;


    public void crearProducto(Producto producto){
        iProductoRepository.save(producto);
    }


    public List<Producto> consultarPorNombre(String nombre) {
        return iProductoRepository.findAllByNombreContaining(nombre);
    }

    public List<Producto> obtenerTodosLosProductos(String categoria) {
        List<Producto> producto =  iProductoRepository.findAll();
        List<Producto> productosCategoria = new ArrayList<>();
        for(Producto p: producto){
            List<Categoria> categorias = p.getCategorias();
            for(Categoria c: categorias){
                if(c.getNombreCategoria().toLowerCase().contains(categoria.toLowerCase())){
                    productosCategoria.add(p);
                }
            }
        }

        return productosCategoria;

    }

}
