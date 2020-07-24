package com.gfi.examen.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "banda")
public class Banda {

    public Banda(){}

    public Banda(String nombre, Timestamp fechaFundacion, int discoLanzados) {
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.discoLanzados = discoLanzados;
    }

    @Column(name="banda_id", nullable=false)
    @Id
    @GeneratedValue(generator="COM_GFI_EXAMEN_MODEL_BANDA_ID_GENERATOR")
    @org.hibernate.annotations.GenericGenerator(name="COM_GFI_EXAMEN_MODEL_BANDA_ID_GENERATOR", strategy="native")
    private Integer bandaId;

    private String nombre;

    @Column(name="fecha_fundacion")
    private java.sql.Timestamp fechaFundacion;

    @Column(name="disco_lanzados")
    private  Integer discoLanzados;

    @ManyToOne(targetEntity= CatTipoMetal.class, fetch=FetchType.LAZY)
    @JoinColumns(value={ @JoinColumn(name="metal_tipo_id", referencedColumnName="metal_tipo_id", nullable=false) }, foreignKey=@ForeignKey(name="FKcatBanda701320"))
    private CatTipoMetal catTipoMetal;

    public Integer getBandaId() {
        return bandaId;
    }

    public void setBandaId(Integer bandaId) {
        this.bandaId = bandaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Timestamp getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Timestamp fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public Integer getDiscoLanzados() {
        return discoLanzados;
    }

    public void setDiscoLanzados(Integer discoLanzados) {
        this.discoLanzados = discoLanzados;
    }

    public CatTipoMetal getCatTipoMetal() {
        return catTipoMetal;
    }

    public void setCatTipoMetal(CatTipoMetal catTipoMetal) {
        this.catTipoMetal = catTipoMetal;
    }
}
