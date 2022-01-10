/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.sgi.service;

import co.com.jh.sgi.entity.Producto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author jsherreram
 */
public interface IProductoService {

    public List<Producto> findAll(Sort sort);

    public Page<Producto> findAll(Pageable pageable);

    public Producto findById(long id);

    public Producto save(Producto producto);

    public void deleteById(long id);

}
