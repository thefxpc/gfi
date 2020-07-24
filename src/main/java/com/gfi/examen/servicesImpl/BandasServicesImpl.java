package com.gfi.examen.servicesImpl;

import com.gfi.examen.httpRequest.AddBandaRequest;
import com.gfi.examen.model.Banda;
import com.gfi.examen.model.CatTipoMetal;
import com.gfi.examen.repository.BandaRepository;
import com.gfi.examen.repository.CatTipoMetalRepository;
import com.gfi.examen.services.BandaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;

@Service
public class BandasServicesImpl implements BandaServices {

    private final BandaRepository bandaRepository;
    private final CatTipoMetalRepository catTipoMetalRepository;

    @Autowired
    public BandasServicesImpl(BandaRepository bandaRepository,
                              CatTipoMetalRepository catTipoMetalRepository){
        this.bandaRepository=bandaRepository;
        this.catTipoMetalRepository=catTipoMetalRepository;
    }

    @Override
    public List<Banda> getBandas() {
        return bandaRepository.findAll();
    }

    @Override
    public Banda addBanda(AddBandaRequest addBandaRequest) {

        Banda banda=new Banda(addBandaRequest.getNombre(),
                new Timestamp(addBandaRequest.getFechaFundacion()),
                addBandaRequest.getDiscoLanzados());

        CatTipoMetal catTipoMetal=catTipoMetalRepository.findByTipo(addBandaRequest.getMetalTipoTipo());
        if(catTipoMetal.getBandas()==null) catTipoMetal.setBandas(new HashSet<>());
        catTipoMetal.getBandas().add(banda);
        banda.setCatTipoMetal(catTipoMetal);

        return bandaRepository.save(banda);
    }

    @Override
    public Banda updateBanda(AddBandaRequest addBandaRequest) {
        Banda banda=bandaRepository.getOne(addBandaRequest.getBandaId());
        banda.setNombre(addBandaRequest.getNombre());
        banda.setFechaFundacion(new Timestamp(addBandaRequest.getFechaFundacion()));
        banda.setDiscoLanzados(addBandaRequest.getDiscoLanzados());


        CatTipoMetal catTipoMetal=catTipoMetalRepository.findByTipo(addBandaRequest.getMetalTipoTipo());
        if(catTipoMetal.getBandas()==null) catTipoMetal.setBandas(new HashSet<>());
        catTipoMetal.getBandas().add(banda);
        banda.setCatTipoMetal(catTipoMetal);

        return bandaRepository.save(banda);
    }

    @Override
    public void deleteBanda(Integer banda_id) {
        Banda banda=bandaRepository.getOne(banda_id);
        bandaRepository.delete(banda);
    }
}
