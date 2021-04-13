package co.prueba.digitalware.springboot.services;

import co.prueba.digitalware.springboot.dtos.PasajeroDto;
import co.prueba.digitalware.springboot.responses.PasajerosListResponse;
import co.prueba.digitalware.springboot.responses.PasajerosResponse;
import org.springframework.http.ResponseEntity;

public interface PasajService {
    ResponseEntity<PasajerosResponse> crearEdPasajero(PasajeroDto pasaj);
    ResponseEntity<PasajerosListResponse> leerPasajeros();
    ResponseEntity<PasajerosResponse> elimPasaj(Long idpasaj);
}
