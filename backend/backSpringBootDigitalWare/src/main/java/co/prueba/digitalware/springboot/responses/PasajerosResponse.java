package co.prueba.digitalware.springboot.responses;


import java.util.List;

public class PasajerosResponse extends ResponseGeneralArr {

    PasajerosResponseDto pasajeros;

    public PasajerosResponse(Integer responseCode, List<String> responseDescription, PasajerosResponseDto pasajero, Integer status) {
        setResponseCode(responseCode);
        setResponseDescription(responseDescription);
        setStatus(status);
        setPasajeros(pasajero);
    }

    public PasajerosResponse(Integer responseCode, List<String> responseDescription, Integer status) {
        setResponseCode(responseCode);
        setResponseDescription(responseDescription);
        setStatus(status);
    }

    public PasajerosResponseDto getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(PasajerosResponseDto pasajeros) {
        this.pasajeros = pasajeros;
    }
}
