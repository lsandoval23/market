package com.ryg.market.persistence.entity;

import javax.persistence.*;

// La anotacion permite mapear la entidad de la base de datos a una clase en Java
@Entity
@Table(name="productos")        // Mapeamos la clase Producto a la tabla productos
public class Producto {

    /** Atributos */

    // Los atributos seran las columnas de la entidad, usar clases Wrapper para los tipos de datos

    @Id                                 // Se usa para especificar que es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Para autogenerar el id cuando se agreguen elementos a la tabla, IDENTITY ya que es clave primaria
    @Column(name = "id_producto")       // Se usa esta anotacion cuando el nombre del atributo es diferente al de la columna en la tabla
    private Integer idProducto;

    private String nombre;              // No es necesario usar la anotacion Column, los nombres son iguales

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    /**
     * <p> Creando las relaciones que existen entre las tablas.
     * Dentro de productos está el campo id_categoria, se indica la relación creando un
     * atributo de la clase categoria y la anotacion @ManyToOne <p/>
     *
     * <p>
     * Esta anotacion se usa para especificar que una categoria puede tener muchos productos
     * <p/>
     *
     * Con la anotacion @JoinColumn la relacionamos con la entidad Categoria
     * mediante la columna id_categoria
     *
     * Con las opciones insertable y updatable indicamos que no podemos insertar, actualizar o
     * eliminar categorias desde
     * la clase productos, solo desde la clase Categoria
     * */

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;


    /** Getters and setter */

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


}
