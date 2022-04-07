package com.ryg.market.persistence.crud;

import com.ryg.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


/**
 * CrudRepository nos permite hacer modificaciones a la tabla, dentro de sus
 * parametros se tiene que especificar la clase (Entidad) que quiere modificar
 * y el tipo de dato de su llave primaria
 * */
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    // Query method, funciones que permiten hacer querys de sql sin la necesidad de usar
    // la anotacion @Query, se tiene una regla especial de nombramiento

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);



    /**
     *  Se puede usar la anotacion @Query para no tener que seguir la reglamentacion
     *  del nombre de un query method y poner un nombre cualquiera al metodo.Ejm
     *
     *  <p>  <p/>
     *
     * */
}
