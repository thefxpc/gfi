package com.gfi.examen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cat_tipo_metal")
public class CatTipoMetal {

    @Column(name="metal_tipo_id", nullable=false)
    @Id
    @GeneratedValue(generator="COM_GFI_EXAMEN_MODEL_CAT_METAL_TIPO_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="COM_GFI_EXAMEN_MODEL_CAT_METAL_TIPO_ID_GENERATOR", strategy="native")
    private Integer metalTipoId;

    @Column(name="tipo", nullable=true, length=255)
    private String tipo;

    @JsonIgnore
    @OneToMany(mappedBy="catTipoMetal", targetEntity=Banda.class)
    private Set<Banda> bandas = new HashSet<>();

    public Integer getMetalTipoId() {
        return metalTipoId;
    }

    public void setMetalTipoId(Integer metalTipoId) {
        this.metalTipoId = metalTipoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Banda> getBandas() {
        return bandas;
    }

    public void setBandas(Set<Banda> bandas) {
        this.bandas = bandas;
    }
}
