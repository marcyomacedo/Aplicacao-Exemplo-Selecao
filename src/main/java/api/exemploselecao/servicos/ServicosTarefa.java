package api.exemploselecao.servicos;

import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import api.exemploselecao.dtos.PesquisaDto;
import api.exemploselecao.dtos.TarefaDto;
import api.exemploselecao.entidades.Tarefa;
import api.exemploselecao.repositorios.TarefaDAO;


@Service
public class ServicosTarefa {
	
	@Autowired
	private TarefaDAO repositorioTarefa;
	@Autowired
	private ServicoJWT servicoJWT;
	
	
	public Tarefa adicionaTarefa(TarefaDto tarefaDto, String header)  throws ServletException, ParseException{
		
		String emailSujeito = servicoJWT.getSujeitoDoToken(header);
		
		
		if(!emailSujeito.isEmpty()) {
			
			Tarefa tarefa = new Tarefa();
			tarefa.setTitulo(tarefaDto.getTitulo());
			tarefa.setDescricao(tarefaDto.getDescricao());
			tarefa.setResponsavel(tarefaDto.getResponsavel());
			tarefa.setPrioridade(tarefaDto.getPrioridade());
			tarefa.setDeadLine(tarefaDto.getDeadLine());
			
			repositorioTarefa.save(tarefa);
			
			return tarefa;	
			
		}
		
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
	}
	
	
	public Tarefa atualizaTarefa(Long id, TarefaDto tarefaDto, String header)  throws ServletException, ParseException{
		
		String emailSujeito = servicoJWT.getSujeitoDoToken(header);
		
		
		if(!emailSujeito.isEmpty()) {
			
			Tarefa tarefa = repositorioTarefa.getById(id);
			tarefa.setTitulo(tarefaDto.getTitulo());
			tarefa.setDescricao(tarefaDto.getDescricao());
			tarefa.setResponsavel(tarefaDto.getResponsavel());
			tarefa.setPrioridade(tarefaDto.getPrioridade());
			tarefa.setDeadLine(tarefaDto.getDeadLine());
			
			repositorioTarefa.save(tarefa);
			
			return tarefa;	
			
		}
		
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
	}

	
	
	public Tarefa apagaTarefa(Long id, String header)  throws ServletException, ParseException{
		
		String emailSujeito = servicoJWT.getSujeitoDoToken(header);
		
		
		if(!emailSujeito.isEmpty()) {
			
			Tarefa tarefa = repositorioTarefa.getById(id);
			repositorioTarefa.delete(tarefa);
			
			return tarefa;
					
		}
		
		
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
	}
	
	
	public List<Tarefa> pesquisaTarefaTituloDescricao(PesquisaDto pesquisa){
		
		String texto = pesquisa.getTexto();
		
		List<Tarefa> tarefaT = repositorioTarefa.findByTituloContaining(texto);
		List<Tarefa> tarefaD = repositorioTarefa.findByDescricaoContaining(texto);
		
		List<Tarefa> resultados = tarefaT;
		resultados.addAll(tarefaD);
		
		return resultados;
		
		
	}
	
	public List<Tarefa> pesquisaTarefaSitucao(PesquisaDto pesquisa){
		
		String texto = pesquisa.getTexto();
		
		List<Tarefa> resultado = repositorioTarefa.findBySituacao(texto);
		
		return resultado;		
		
	}
	
	public List<Tarefa> pesquisaTarefaResposavel(PesquisaDto pesquisa){
		
		String texto = pesquisa.getTexto();
		
		List<Tarefa> resultado = repositorioTarefa.findByResponsavel(texto);
		
		return resultado;
	}
	
	public Tarefa pesquisaTarefaNumero(Long id){
		
		Tarefa resultado = repositorioTarefa.getById(id);
		
		return resultado;
	}
	
	public Tarefa concluiTarefa(Long id, String header) {
		
		String emailSujeito = servicoJWT.getSujeitoDoToken(header);
		
		
		if(!emailSujeito.isEmpty()) {
			
			Tarefa tarefa = repositorioTarefa.getById(id);
			
			tarefa.setSituacao("Concluída");
			
			return tarefa;
		}
		
		throw new HttpClientErrorException(HttpStatus.FORBIDDEN);		
		
	}
	
	

}
