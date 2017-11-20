package br.edu.unoesc.DescobrirAPalavra.modelo;

import java.io.Serializable;

import br.edu.unoesc.DescobrirAPalavra.RenderizaCombo;

public class CodUserAtual implements Serializable, RenderizaCombo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -335996546465030896L;
	private Long codigo;
	private Long cod_user_atual;

	public long getCod_user_atual(){
		return cod_user_atual;
	}

	public void setCod_user_atual(long cod_user_atual) {
		this.cod_user_atual = cod_user_atual;
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "CodUserAtual [codigo=" + codigo + ", cod_user_atual=" + cod_user_atual + "]";
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
		CodUserAtual other = (CodUserAtual) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
