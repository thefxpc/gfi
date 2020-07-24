package com.gfi.examen.httpRequest;

public class AddBandaRequest {
    private int bandaId;
    private String metalTipoTipo;
    private String nombre;
    private Integer discoLanzados;
    private Long fechaFundacion;

    public String getMetalTipoTipo() {
        return metalTipoTipo;
    }

    public void setMetalTipoTipo(String metalTipoTipo) {
        this.metalTipoTipo = metalTipoTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDiscoLanzados() {
        return discoLanzados;
    }

    public void setDiscoLanzados(Integer discoLanzados) {
        this.discoLanzados = discoLanzados;
    }

    public Long getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(Long fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public int getBandaId() {
        return bandaId;
    }

    public void setBandaId(int bandaId) {
        this.bandaId = bandaId;
    }
}
