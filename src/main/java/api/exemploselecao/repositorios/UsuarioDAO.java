package api.exemploselecao.repositorios;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.exemploselecao.entidades.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, String>{
	
	Optional<Usuario> findByEmail(String email);

}