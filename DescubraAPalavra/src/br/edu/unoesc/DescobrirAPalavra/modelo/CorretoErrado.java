package br.edu.unoesc.DescobrirAPalavra.modelo;

public class CorretoErrado {

	private String correto="Correto";
	private String errado="Errado";
	
	public String getCorreto() {
		return correto;
	}
	public void setCorreto(String correto) {
		this.correto = correto;
	}
	public String getErrado() {
		return errado;
	}
	public void setErrado(String errado) {
		this.errado = errado;
	}
	@Override
	public String toString() {
		return "CorretoErrado [correto=" + correto + ", errado=" + errado + "]";
	}
	
	
}
