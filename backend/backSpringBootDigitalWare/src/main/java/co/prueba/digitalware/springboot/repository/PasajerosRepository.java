package co.prueba.digitalware.springboot.repository;

import co.prueba.digitalware.springboot.entities.PasajerosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PasajerosRepository extends JpaRepository<PasajerosEntity, Long> {
}
