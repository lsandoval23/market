package com.ryg.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    /** Atributos*/

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    private String descripcion;
    private Boolean estado;


    /** Indexamos la clase Categoria con la clase Productos por la relacion
     * @OneToMany, para indicar que una categoria puede abarcar muchos productos
     * se mapea por el atributo categoria de la clase Producto.
     *
     * */

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;


    /** Getters and setters */

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
