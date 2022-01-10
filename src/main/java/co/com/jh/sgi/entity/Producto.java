/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.sgi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author jsherreram
 */
@Entity
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long idProducto;

    @NotEmpty(message = "El campo nombre producto no puede estar vacío")
    @Size(min = 4, max = 255, message = "El campo nombre producto debe tener entre 4 y 255 caracteres")
    private String nombre;

    @Size(max = 255, message = "El campo descripción producto debe tener no mas de 255 caracteres")
    private String descripcion;

    @Min(value = 0, message = "El campo precio producto debe ser mayor o igual a cero")
    private double precio;

    @Min(value = 0, message = "El campo stock producto debe ser mayor o igual a cero")
    private long stock;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @NotNull(message = "El campo presentación no puede ser nulo")
    private Presentacion presentacion;

}
