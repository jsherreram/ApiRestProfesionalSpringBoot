/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.sgi.dao;

import co.com.jh.sgi.entity.Producto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author jsherreram
 */
public interface IProductoDao extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT p FROM Producto p LEFT JOIN FETCH p.presentacion")
    public List<Producto> findAll(Sort sort);

    @Query(value = "SELECT p FROM Producto p LEFT JOIN FETCH p.presentacion", countQuery = "SELECT COUNT(p) FROM Producto p LEFT JOIN p.presentacion")
    public Page<Producto> findAll(Pageable pageable);

    @Query(value = "SELECT p FROM Producto p LEFT JOIN FETCH p.presentacion WHERE p.idProducto = :id")
    public Producto findById(long id);

}
