package api.exemploselecao.dtos;

public class UsuarioDto {
	
	
	private String email;	
	private String nome;
	private String ultimoNome;
	private Long numeroCartao;
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
	public Long getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(Long numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public UsuarioDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDto(String email, String nome, String ultimoNome, Long numeroCartao, String senha) {
		super();
		this.email = email;
		this.nome = nome;
		this.ultimoNome = ultimoNome;
		this.numeroCartao = numeroCartao;
		this.senha = senha;
	}
	
	


}

