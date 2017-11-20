package br.edu.unoesc.DescobrirAPalavra.modelo;

import java.io.Serializable;

import br.edu.unoesc.DescobrirAPalavra.RenderizaCombo;

public class Pontuacao implements Serializable, RenderizaCombo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 122495483524520739L;

	private Long codigo;
	private Long pontos=100l;
	private Long codusuario;
	private int qtd_perguntas;
	private String assunto;
	private String data;
	
	

	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getAssunto() {
		return assunto;
	}



	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}



	public int getQtd_perguntas() {
		return qtd_perguntas;
	}



	public void setQtd_perguntas(int qtd_perguntas) {
		this.qtd_perguntas = qtd_perguntas;
	}



	public Long getCodusuario() {
		return codusuario;
	}



	public void setCodusuario(Long codusuario) {
		this.codusuario = codusuario;
	}


	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}






	public Long getPontos() {
		return pontos;
	}



	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}



	



	@Override
	public String toString() {
		return "Pontuacao [codigo=" + codigo + ", pontos=" + pontos + ", codusuario=" + codusuario + ", qtd_perguntas="
				+ qtd_perguntas + ", assunto=" + assunto + ", data=" + data + "]";
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
		Pontuacao other = (Pontuacao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	@Override
	public String getText() {
		return null;
	}

	
}
