package com.gfi.examen.servicesImpl;

import com.gfi.examen.model.CatTipoMetal;
import com.gfi.examen.repository.CatTipoMetalRepository;
import com.gfi.examen.services.CatTipoMetalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatTipoMetalServicesImpl implements CatTipoMetalServices {

    public CatTipoMetalRepository catTipoMetalRepository;

    @Autowired
    public CatTipoMetalServicesImpl(CatTipoMetalRepository catTipoMetalRepository){
        this.catTipoMetalRepository=catTipoMetalRepository;
    }

    @Override
    public List<CatTipoMetal> getCatTipoMetal() {
        return catTipoMetalRepository.findAll();
    }
}
