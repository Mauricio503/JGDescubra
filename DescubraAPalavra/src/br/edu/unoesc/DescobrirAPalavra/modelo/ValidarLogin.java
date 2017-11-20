package br.edu.unoesc.DescobrirAPalavra.modelo;

public class ValidarLogin {
	
	private String usuario;
	private String usuariodig;
	private String senha;
	private String senhadig;

	
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getUsuariodig() {
		return usuariodig;
	}
	public void setUsuariodig(String usuariodig) {
		this.usuariodig = usuariodig;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenhadig() {
		return senhadig;
	}
	public void setSenhadig(String senhadig) {
		this.senhadig = senhadig;
	}
	@Override
	public String toString() {
		return "ValidarLogin [usuario=" + usuario + ", usuariodig=" + usuariodig + ", senha=" + senha + ", senhadig="
				+ senhadig + "]";
	}
	
	
	
	
	
	
		
	
}
