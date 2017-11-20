package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.util.List;

public interface CrudDaoPontos <T>{

	T get(String codusuario);
	
	List<T> listarpontos();
}
