package com.gfi.examen.rest;

import com.gfi.examen.httpResponse.MessageResponse;
import com.gfi.examen.services.CatTipoMetalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CatTipoMetalAPI {

    private final CatTipoMetalServices catTipoMetalServices;

    @Autowired
    public CatTipoMetalAPI(CatTipoMetalServices catTipoMetalServices){
        this.catTipoMetalServices=catTipoMetalServices;
    }


    @GetMapping("catTipoMetal")
    public ResponseEntity<?> getCatTipoMetal(){
        try{
            return ResponseEntity.ok(catTipoMetalServices.getCatTipoMetal());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage(),false));
        }
    }
}
