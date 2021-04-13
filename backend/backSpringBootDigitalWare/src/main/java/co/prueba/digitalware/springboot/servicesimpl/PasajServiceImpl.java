package co.prueba.digitalware.springboot.servicesimpl;

import co.prueba.digitalware.springboot.dtos.PasajeroDto;
import co.prueba.digitalware.springboot.entities.PasajerosEntity;
import co.prueba.digitalware.springboot.repository.PasajerosRepository;
import co.prueba.digitalware.springboot.responses.*;
import co.prueba.digitalware.springboot.services.PasajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Lazy
@Service
public class PasajServiceImpl implements PasajService {
    @Autowired
    private PasajerosRepository pasajerosRepository;

    @Value("${dateFormat}")
    private String format;


    @Override
    public ResponseEntity<PasajerosResponse> crearEdPasajero(PasajeroDto pasaj) {

        List<String> listMess = new ArrayList<>();

        try {
            PasajerosEntity pasajerosEntity = new PasajerosEntity();
            if (Objects.isNull(pasaj.getId())==false){
                pasajerosEntity.setId(pasaj.getId());
            }
            pasajerosEntity.setTipdocumento(pasaj.getTipdocumento());
            pasajerosEntity.setEmail(pasaj.getEmail());
            pasajerosEntity.setIdentificacion(pasaj.getIdentificacion());
            pasajerosEntity.setPnombre(pasaj.getPnombre());
            pasajerosEntity.setPapellido(pasaj.getPapellido());
            pasajerosEntity.setSapellido(pasaj.getSapellido());
            pasajerosEntity.setSnombre(pasaj.getSnombre());
            pasajerosEntity.setNcelular(pasaj.getNcelular());
            PasajerosEntity pasajeroSaved = pasajerosRepository.save(pasajerosEntity);
            PasajerosResponseDto pasajerosResponseDto = new PasajerosResponseDto(pasajeroSaved);

            return new ResponseEntity<>(new PasajerosResponse(1, listMess, pasajerosResponseDto, HttpStatus.OK.value()), HttpStatus.OK);


        }
        catch (Exception e) {
            listMess.add("Ocurrio un error al guardar el Pasajero");
            return new ResponseEntity<>(new PasajerosResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<PasajerosListResponse> leerPasajeros() {


        return new ResponseEntity<>(new PasajerosListResponse(1, null, pasajerosRepository.findAll(), HttpStatus.OK.value()), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<PasajerosResponse> elimPasaj(Long idpasaj) {
        List<String> listMess = new ArrayList<>();
        try {
            pasajerosRepository.deleteById(idpasaj);
            listMess.add("Se elimina ok");
            return new ResponseEntity<>(new PasajerosResponse(1, listMess, null, HttpStatus.OK.value()), HttpStatus.OK);

        } catch (Exception e) {
            listMess.add("Ocurrio un error al eliminar el Pasajero");
            return new ResponseEntity<>(new PasajerosResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // TODO Auto-generated method stub



    }
}
