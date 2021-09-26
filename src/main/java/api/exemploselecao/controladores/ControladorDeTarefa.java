package api.exemploselecao.controladores;

import java.text.ParseException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import api.exemploselecao.dtos.TarefaDto;
import api.exemploselecao.entidades.Tarefa;
import api.exemploselecao.servicos.ServicosTarefa;

@RestController
public class ControladorDeTarefa {
	
	@Autowired
	private ServicosTarefa servicoTarefa;
	
	@PostMapping("v1/api/tarefa")
	public ResponseEntity<Tarefa> adicionaTarefa(@RequestBody TarefaDto tarefa,
			@RequestHeader("Authorization") String header) throws ServletException, ParseException{
		
		return new ResponseEntity<Tarefa>(servicoTarefa.adicionaTarefa(tarefa, header), HttpStatus.CREATED);
	}
	
	@PatchMapping("v1/api/tarefa/{id}")
    public ResponseEntity<Tarefa> atualizaTarefa(@PathVariable Long id, 
    		@RequestBody TarefaDto tarefa, @RequestHeader("Authorization") String header){		
		try {
            return new ResponseEntity<>(servicoTarefa.atualizaTarefa(id, tarefa, header), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@DeleteMapping("v1/api/tarefa/{id}")
    public ResponseEntity<Tarefa> apagaTarefa(@PathVariable Long id, 
    		@RequestHeader("Authorization") String header)throws Exception, ServletException  {
        try {
            return new ResponseEntity<>(servicoTarefa.apagaTarefa(id, header), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
