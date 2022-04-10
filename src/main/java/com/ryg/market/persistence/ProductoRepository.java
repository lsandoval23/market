package com.ryg.market.persistence;

import com.ryg.market.domain.Product;
import com.ryg.market.domain.repository.ProductRepository;
import com.ryg.market.persistence.crud.ProductoCrudRepository;
import com.ryg.market.persistence.entity.Producto;
import com.ryg.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


// Con la clase Repository, instanciando un objeto de la clase crudrepository crearemos metodos
// a partir de los metodos proporcionados por el crudrepository


// Con esta anotacion le indicamos a spring que esta clase es la que interactua con la base de datos, se puede usar
// la anotacion @Component
@Repository
public class ProductoRepository implements ProductRepository {

    /** Atributos */
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    // Mapear el producto a product usando el mapper nos permite que el repository no sea tan dependiente
    // a una estructura de base de datos en especifico y da seguridad de acceso para no mostrar
    // completamente la estructura de datos

    /** Metodos de la clase */

    // Obtenemos todos los productos de la tabla Producto, el metodo findAll es nativo de CrudRepository
    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    // Obtener un producto por un ID
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    // Obtener productos escasos
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    // Obtener un producto por su ID
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    // Guardar un producto
    @Override
    public Product save(Product product){
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    // Eliminar un productos
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }



    /**
     *
     * ProductoRepository usando directmente la entidad Producto
     *
     * public class ProductoRepository {
     *     private ProductoCrudRepository productoCrudRepository;
     *
     *     public List<Producto> getAll() {
     *         return (List<Producto>) productoCrudRepository.findAll();
     *     }
     *
     *     public List<Producto> getByCategoria(int idCategoria) {
     *         return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
     *     }
     *
     *     public Optional<List<Producto>> getEscasos(int cantidad) {
     *         return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
     *     }
     *
     *     public Optional<Producto> getProducto(int idProducto) {
     *         return productoCrudRepository.findById(idProducto);
     *     }
     *
     *     public Producto save(Producto producto) {
     *         return productoCrudRepository.save(producto);
     *     }
     *
     *     public void delete(int idProducto) {
     *         productoCrudRepository.deleteById(idProducto);
     *     }
     * }
     *
     * */



}
