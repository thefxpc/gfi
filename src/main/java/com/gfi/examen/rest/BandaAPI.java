package com.gfi.examen.rest;

import com.gfi.examen.httpRequest.AddBandaRequest;
import com.gfi.examen.httpResponse.MessageResponse;
import com.gfi.examen.services.BandaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BandaAPI {

    private final BandaServices bandaServices;

    @Autowired
    public BandaAPI(BandaServices bandaServices){
        this.bandaServices=bandaServices;
    }

    @GetMapping("/banda")
    public ResponseEntity<?> getBandas(){
        try{
            return ResponseEntity.ok(bandaServices.getBandas());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage(),false));
        }
    }

    @PostMapping("/banda")
    public ResponseEntity<?> addBanda(@RequestBody AddBandaRequest addBandaRequest){
        try{
            return ResponseEntity.ok(bandaServices.addBanda(addBandaRequest));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage(),false));
        }
    }


    @PutMapping("/banda")
    public ResponseEntity<?> updateBanda(@RequestBody AddBandaRequest addBandaRequest){
        try{
            return ResponseEntity.ok(bandaServices.updateBanda(addBandaRequest));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage(),false));
        }
    }

    @DeleteMapping("/banda/{banda_id}")
    public ResponseEntity<?> deleteBanda(@PathVariable Integer banda_id){
        try{
            bandaServices.deleteBanda(banda_id);
            return ResponseEntity.badRequest().body(new MessageResponse("Banda eliminada",true));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage(),false));
        }
    }
}
