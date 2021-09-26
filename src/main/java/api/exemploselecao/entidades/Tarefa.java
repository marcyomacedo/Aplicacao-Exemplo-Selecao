package api.exemploselecao.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private String responsavel;
	private String prioridade;
	private Date deadLine;
	private String situacao = "Em andamento";
	


	
	public Long getId() {
		return id;
	}




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



	public Date getDeadLine() {
		return deadLine;
	}



	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}



	public String getSituacao() {
		return situacao;
	}




	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}




	public Tarefa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
