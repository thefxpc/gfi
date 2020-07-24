package com.gfi.examen.repository;

import com.gfi.examen.model.CatTipoMetal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatTipoMetalRepository extends JpaRepository<CatTipoMetal,Integer> {
    CatTipoMetal findByTipo(String tipo);
}
