package co.prueba.digitalware.springboot.responses;


import co.prueba.digitalware.springboot.entities.PasajerosEntity;
import co.prueba.digitalware.springboot.repository.PasajerosRepository;

import java.util.List;

public class PasajerosListResponse extends ResponseGeneralArr {

    List<PasajerosEntity> pasajeros;

    public PasajerosListResponse(Integer responseCode, List<String> responseDescription, List<PasajerosEntity> pasajero, Integer status) {
        setResponseCode(responseCode);
        setResponseDescription(responseDescription);
        setStatus(status);
        setPasajeros(pasajero);
    }

    public PasajerosListResponse(Integer responseCode, List<String> responseDescription, Integer status) {
        setResponseCode(responseCode);
        setResponseDescription(responseDescription);
        setStatus(status);
    }

    public List<PasajerosEntity> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<PasajerosEntity> pasajeros) {
        this.pasajeros = pasajeros;
    }
}
