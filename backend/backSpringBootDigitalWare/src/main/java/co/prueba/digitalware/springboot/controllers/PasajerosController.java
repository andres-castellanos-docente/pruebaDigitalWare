package co.prueba.digitalware.springboot.controllers;

import co.prueba.digitalware.springboot.dtos.PasajeroDto;
import co.prueba.digitalware.springboot.responses.PasajerosListResponse;
import co.prueba.digitalware.springboot.responses.PasajerosResponse;
import co.prueba.digitalware.springboot.services.PasajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/servicios")
public class PasajerosController {


    @Lazy
    @Autowired
    PasajService pasajService;


    @PostMapping("/pasaj")
    public ResponseEntity<PasajerosResponse> addPasaj(@RequestBody PasajeroDto pasaj) {
        return pasajService.crearEdPasajero(pasaj);
    }

    @PutMapping("/pasaj")
    public ResponseEntity<PasajerosResponse> modClient(@RequestBody PasajeroDto client) {
        return pasajService.crearEdPasajero(client);
    }

    @GetMapping("/pasaj")
    public ResponseEntity<PasajerosListResponse> getPasajeros() {
        return pasajService.leerPasajeros();
    }

    @DeleteMapping("/pasaj/{id}")
    public ResponseEntity<PasajerosResponse> elPasaj(@PathVariable(value = "id") Long IdPas) {
        return pasajService.elimPasaj(IdPas);
    }


}

