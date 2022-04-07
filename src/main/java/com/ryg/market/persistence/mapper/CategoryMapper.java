package com.ryg.market.persistence.mapper;

import com.ryg.market.domain.Category;
import com.ryg.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// Esta clase mapea la entidad Producto a la clase Product
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    // Esta anotacion indica que el mapeo es inverso al que indica la anotacion mappings
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)   // Le decimos que ignore el atributo productos de la clase Categoria
    Categoria toCategoria(Category category);




}
