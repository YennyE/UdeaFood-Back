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

    public List<ProductoDTO> obtenerTodosLosProductos(String categoria) {
        List<Producto> productos = iProductoRepository.findAll();
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for (Producto p : productos) {
            List<Categoria> categorias = p.getCategorias();

            for (Categoria c : categorias) {
                if (c.getNombreCategoria().toLowerCase().contains(categoria.toLowerCase())) {
                    byte[] foto = (p.getImagen() != null) ? p.getImagen().getImagen() : null;
                    ProductoDTO productoDTO = new ProductoDTO(
                            p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio(),
                            p.getDisponibilidad(), foto, p.getSeccion(), p.getCategorias()
                    );
                    productosDTO.add(productoDTO);
                }
            }
        }

        return productosDTO;
    }


    public void eliminarProducto(Integer id) {
        Producto producto = iProductoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El producto con ID " + id + " no existe."));

        // Limpiar relaciones con categorías
        producto.getCategorias().clear();

        // Desvincular la relación con Sección
        producto.setSeccion(null);
        iProductoRepository.save(producto);

        // Eliminar la imagen si existe
        if (producto.getImagen() != null) {
            iImageRepository.delete(producto.getImagen());
        }

        // Eliminar el producto
        iProductoRepository.delete(producto);
    }




}
