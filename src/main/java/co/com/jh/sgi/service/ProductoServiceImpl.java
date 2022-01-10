/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.jh.sgi.service;

import co.com.jh.sgi.entity.Presentacion;
import co.com.jh.sgi.entity.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.com.jh.sgi.dao.IPresentacionDao;
import co.com.jh.sgi.dao.IProductoDao;

/**
 *
 * @author jsherreram
 */
@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private IPresentacionDao presentacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll(Sort sort) {
        return productoDao.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Producto> findAll(Pageable pageable) {
        return productoDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(long id) {
        return productoDao.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        Presentacion presentacion = presentacionDao.
                findById(producto.getPresentacion().getIdPresentacion()).orElse(null);
        producto.setPresentacion(presentacion);
        return productoDao.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        productoDao.deleteById(id);
    }

}
