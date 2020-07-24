package com.gfi.examen.services;

import com.gfi.examen.httpRequest.AddBandaRequest;
import com.gfi.examen.model.Banda;

import java.util.List;

public interface BandaServices {
    List<Banda> getBandas();
    Banda addBanda(AddBandaRequest addBandaRequest);
    Banda updateBanda(AddBandaRequest addBandaRequest);
    void deleteBanda(Integer banda_id);
}
