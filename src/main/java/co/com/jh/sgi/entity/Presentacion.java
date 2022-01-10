/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.sgi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author jsherreram
 */
@Entity
@Table(name = "presentacion")
@Data
public class Presentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presentacion")
    private long idPresentacion;

    @NotEmpty(message = "El campo nombre presentación no puede estar vacío")
    @Size(min = 4, max = 255, message = "El campo nombre presentación debe tener entre 4 y 255 caracteres")
    private String nombre;

    @Size(max = 255, message = "El campo descripción presentación debe tener no mas de 255 caracteres")
    private String descripcion;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "presentacion")
    private List<Producto> productos;

}
