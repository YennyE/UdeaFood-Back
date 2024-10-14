package com.UdeaFood_Back.Service;

import com.UdeaFood_Back.DTO.ProductoDTO;
import com.UdeaFood_Back.Modelo.*;
import com.UdeaFood_Back.Repository.IImagenRepository;
import com.UdeaFood_Back.Repository.IProductoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductoService {

    private final IProductoRepository iProductoRepository;
    private final IImagenRepository iImageRepository;


    public void crearProducto(ProductoDTO productoDTO) {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setDisponibilidad(productoDTO.getDisponibilidad());

        // CAMBIAR POR EL ID DE UNA TIENDA QUE EXISTA
        Tienda tienda = new Tienda();
        tienda.setId(1);

        producto.setSeccion(productoDTO.getSeccion());
        producto.setCategorias(productoDTO.getCategoria());

        if (productoDTO.getFoto() != null) {

            ImagenProducto imagen = new ImagenProducto();
            imagen.setProducto(producto);
            imagen.setImagen(productoDTO.getFoto());
            iImageRepository.save(imagen);

        } else {
            System.out.println("############################################################################################No hay fotos");
        }
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
    // para el tipo de tienda
   // public List<Producto>obtenerProductosPorTipoTienda(String tipoTienda){
     //   return iProductoRepository.findByTipoTienda(tipoTienda);
    //}

}
