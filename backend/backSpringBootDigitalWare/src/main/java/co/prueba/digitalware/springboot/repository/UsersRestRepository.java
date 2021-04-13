package co.prueba.digitalware.springboot.repository;

import co.prueba.digitalware.springboot.entities.UsuariosrestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRestRepository extends JpaRepository<UsuariosrestEntity, Long> {
	Optional<UsuariosrestEntity> findByUsername(String username);
}
