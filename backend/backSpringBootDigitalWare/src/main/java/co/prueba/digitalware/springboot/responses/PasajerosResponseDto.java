package co.prueba.digitalware.springboot.responses;

import co.prueba.digitalware.springboot.entities.PasajerosEntity;


public class PasajerosResponseDto {
    public PasajerosResponseDto(PasajerosEntity pasajerosEntity) {
        setId(pasajerosEntity.getId());
        setEmail(pasajerosEntity.getEmail());
        setNcelular(pasajerosEntity.getNcelular());
        setTipDocumento(pasajerosEntity.getTipdocumento());
        setPnombre(pasajerosEntity.getPnombre());
        setPapellido(pasajerosEntity.getPapellido());
        setSapellido(pasajerosEntity.getSapellido());
        setSnombre(pasajerosEntity.getSnombre());
        setIdentificacion(pasajerosEntity.getIdentificacion());

    }
    private Long id;
    private Short tipdocumento;
    private Long identificacion;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String sapellido;
    private String email;
    private Long ncelular;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getTipdocumento() {
        return tipdocumento;
    }

    public void setTipDocumento(Short tipdocumento) {
        this.tipdocumento = tipdocumento;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNcelular() {
        return ncelular;
    }

    public void setNcelular(Long ncelular) {
        this.ncelular = ncelular;
    }
}
