package br.edu.unoesc.DescobrirAPalavra.modelo;

import java.io.Serializable;

import br.edu.unoesc.DescobrirAPalavra.RenderizaCombo;

public class Perguntas implements Serializable, RenderizaCombo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1364540200269248477L;

	private Long codigo;
	private String assunto;
	private String pergunta1;
	private String dica1perg1;
	private String dica2perg1;
	private String dica3perg1;
	private String respperg1;
	private String pergunta2;
	private String dica1perg2;
	private String dica2perg2;
	private String dica3perg2;
	private String respperg2;
	private String pergunta3;
	private String dica1perg3;
	private String dica2perg3;
	private String dica3perg3;
	private String respperg3;
	private String pergunta4;
	private String dica1perg4;
	private String dica2perg4;
	private String dica3perg4;
	private String respperg4;
	private String pergunta5;
	private String dica1perg5;
	private String dica2perg5;
	private String dica3perg5;
	private String respperg5;
	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getPergunta1() {
		return pergunta1;
	}

	public void setPergunta1(String pergunta1) {
		this.pergunta1 = pergunta1;
	}

	public String getDica1perg1() {
		return dica1perg1;
	}

	public void setDica1perg1(String dica1perg1) {
		this.dica1perg1 = dica1perg1;
	}

	public String getDica2perg1() {
		return dica2perg1;
	}

	public void setDica2perg1(String dica2perg1) {
		this.dica2perg1 = dica2perg1;
	}

	public String getDica3perg1() {
		return dica3perg1;
	}

	public void setDica3perg1(String dica3perg1) {
		this.dica3perg1 = dica3perg1;
	}

	public String getRespperg1() {
		return respperg1;
	}

	public void setRespperg1(String respperg1) {
		this.respperg1 = respperg1;
	}

	public String getPergunta2() {
		return pergunta2;
	}

	public void setPergunta2(String pergunta2) {
		this.pergunta2 = pergunta2;
	}

	public String getDica1perg2() {
		return dica1perg2;
	}

	public void setDica1perg2(String dica1perg2) {
		this.dica1perg2 = dica1perg2;
	}

	public String getDica2perg2() {
		return dica2perg2;
	}

	public void setDica2perg2(String dica2perg2) {
		this.dica2perg2 = dica2perg2;
	}

	public String getDica3perg2() {
		return dica3perg2;
	}

	public void setDica3perg2(String dica3perg2) {
		this.dica3perg2 = dica3perg2;
	}

	public String getRespperg2() {
		return respperg2;
	}

	public void setRespperg2(String respperg2) {
		this.respperg2 = respperg2;
	}

	public String getPergunta3() {
		return pergunta3;
	}

	public void setPergunta3(String pergunta3) {
		this.pergunta3 = pergunta3;
	}

	public String getDica1perg3() {
		return dica1perg3;
	}

	public void setDica1perg3(String dica1perg3) {
		this.dica1perg3 = dica1perg3;
	}

	public String getDica2perg3() {
		return dica2perg3;
	}

	public void setDica2perg3(String dica2perg3) {
		this.dica2perg3 = dica2perg3;
	}

	public String getDica3perg3() {
		return dica3perg3;
	}

	public void setDica3perg3(String dica3perg3) {
		this.dica3perg3 = dica3perg3;
	}

	public String getRespperg3() {
		return respperg3;
	}

	public void setRespperg3(String respperg3) {
		this.respperg3 = respperg3;
	}

	public String getPergunta4() {
		return pergunta4;
	}

	public void setPergunta4(String pergunta4) {
		this.pergunta4 = pergunta4;
	}

	public String getDica1perg4() {
		return dica1perg4;
	}

	public void setDica1perg4(String dica1perg4) {
		this.dica1perg4 = dica1perg4;
	}

	public String getDica2perg4() {
		return dica2perg4;
	}

	public void setDica2perg4(String dica2perg4) {
		this.dica2perg4 = dica2perg4;
	}

	public String getDica3perg4() {
		return dica3perg4;
	}

	public void setDica3perg4(String dica3perg4) {
		this.dica3perg4 = dica3perg4;
	}

	public String getRespperg4() {
		return respperg4;
	}

	public void setRespperg4(String respperg4) {
		this.respperg4 = respperg4;
	}

	public String getPergunta5() {
		return pergunta5;
	}

	public void setPergunta5(String pergunta5) {
		this.pergunta5 = pergunta5;
	}

	public String getDica1perg5() {
		return dica1perg5;
	}

	public void setDica1perg5(String dica1perg5) {
		this.dica1perg5 = dica1perg5;
	}

	public String getDica2perg5() {
		return dica2perg5;
	}

	public void setDica2perg5(String dica2perg5) {
		this.dica2perg5 = dica2perg5;
	}

	public String getDica3perg5() {
		return dica3perg5;
	}

	public void setDica3perg5(String dica3perg5) {
		this.dica3perg5 = dica3perg5;
	}

	public String getRespperg5() {
		return respperg5;
	}

	public void setRespperg5(String respperg5) {
		this.respperg5 = respperg5;
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
		Perguntas other = (Perguntas) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Override
	public String getText() {
		return this.assunto;
	}

	@Override
	public String toString() {
		return "Perguntas [codigo=" + codigo + ", assunto=" + assunto + ", pergunta1=" + pergunta1 + ", dica1perg1="
				+ dica1perg1 + ", dica2perg1=" + dica2perg1 + ", dica3perg1=" + dica3perg1 + ", respperg1=" + respperg1
				+ ", pergunta2=" + pergunta2 + ", dica1perg2=" + dica1perg2 + ", dica2perg2=" + dica2perg2
				+ ", dica3perg2=" + dica3perg2 + ", respperg2=" + respperg2 + ", pergunta3=" + pergunta3
				+ ", dica1perg3=" + dica1perg3 + ", dica2perg3=" + dica2perg3 + ", dica3perg3=" + dica3perg3
				+ ", respperg3=" + respperg3 + ", pergunta4=" + pergunta4 + ", dica1perg4=" + dica1perg4
				+ ", dica2perg4=" + dica2perg4 + ", dica3perg4=" + dica3perg4 + ", respperg4=" + respperg4
				+ ", pergunta5=" + pergunta5 + ", dica1perg5=" + dica1perg5 + ", dica2perg5=" + dica2perg5
				+ ", dica3perg5=" + dica3perg5 + ", respperg5=" + respperg5 + "]";
	}
	
	

}
