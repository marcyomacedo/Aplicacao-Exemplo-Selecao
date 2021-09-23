package api.exemploselecao.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	private String email;
	
	private String nome;
	private String ultimoNome;
	private String senha;
	
	
	
	
	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getUltimoNome() {
		return ultimoNome;
	}



	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
