package api.exemploselecao.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.exemploselecao.entidades.Tarefa;
@Repository
public interface TarefaDAO extends JpaRepository<Tarefa, Long>{

}
