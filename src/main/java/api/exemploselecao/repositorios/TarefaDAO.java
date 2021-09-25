package api.exemploselecao.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.exemploselecao.entidades.Tarefa;



@Repository
public interface TarefaDAO extends JpaRepository<Tarefa, Long>{
	
	List<Tarefa> findByResponsavel(String responsavel);
	List<Tarefa> findBySituacao(String situacao);
	List<Tarefa> findByTituloContaining(String titulo);
	List<Tarefa> findByDescricaoContaining(String descricao);

}
