package com.tienda_v1.service.impl;

import com.tienda_v1.dao.CategoriaDao;
import com.tienda_v1.domain.Categoria;
import com.tienda_v1.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired //La anotacion autowired crea un unico objeto mientras se ejecuta la aplicacion   
    private CategoriaDao categoriaDao;
    public List<Categoria> getCategorias(boolean activos){
        var lista = categoriaDao.findAll(); //encontrar todos los datos que tenga la lista
        
        if(activos){
            lista.removeIf(e-> !e.isActivo()); //nos permite saber si el objeto esta activo o no
        }
        return lista;
    }
}
