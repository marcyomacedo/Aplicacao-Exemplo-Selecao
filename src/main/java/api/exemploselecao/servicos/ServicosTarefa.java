package api.exemploselecao.servicos;

import java.text.ParseException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import api.exemploselecao.dtos.TarefaDto;
import api.exemploselecao.entidades.Tarefa;
import api.exemploselecao.entidades.Usuario;
import api.exemploselecao.repositorios.TarefaDAO;
import api.exemploselecao.repositorios.UsuarioDAO;


@Service
public class ServicosTarefa {
	
	@Autowired
	private TarefaDAO repositorioTarefa;
	@Autowired
	private UsuarioDAO repositorioUsuario;
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

}
