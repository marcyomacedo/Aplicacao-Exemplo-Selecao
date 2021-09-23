package api.exemploselecao.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TarefaDto {
	
	private String titulo;
	private String descricao;
	private String responsavel;
	private String prioridade;
	private String deadLine;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	public Date getDeadLine() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataFormatada = formato.parse(this.deadLine);	
		
		return dataFormatada;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public TarefaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
