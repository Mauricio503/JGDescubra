package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.util.List;

public interface CrudDaoLogin <T> {

	T get(String usuario);
	
	List<T> listarlogin();
}
