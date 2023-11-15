
package com.tienda_v1.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="Producto")
public class Producto implements Serializable{ //Funciona para almacenar ciertos datos
    
    private static final long serialVersionUID = 1L; //Para poder el ciclo de la sumatoria del idProducto
    
    @Id //Tabla producto tiene una llave o identificador, sera el ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que tipo de estrategia utilizan, identico = sea igual en la BD y en la clase
    @Column(name="id_producto")
    private long idProducto;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;   
    
    private String detalle;
    private double precio;
    private int existencias;
    //private long idCategoria;
    
    @ManyToOne
    @JoinColumn (name= "id_categoria")
    Categoria categoria;
    
    public Producto(){
        
    }

    public Producto(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    
}
