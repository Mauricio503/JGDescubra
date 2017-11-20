package br.edu.unoesc.DescobrirAPalavra.modelo;

import java.io.Serializable;

import br.edu.unoesc.DescobrirAPalavra.RenderizaCombo;


public class Usuario implements Serializable, RenderizaCombo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7742147873761007845L;

	private Long codigo;
	private String usuario;
	private String senha;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "Cadastrar [codigo=" + codigo + ", usuario=" + usuario + ", senha=" + senha + "]";
	}
	@Override
	public String getText() {
		return this.usuario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}