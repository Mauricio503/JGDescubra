package br.edu.unoesc.DescobrirAPalavra.DAO;

public class DaoFactory {

	private static DaoFactory daoFactory;
	
	public static DaoFactory get(){
		if(daoFactory == null){
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}
	public CodUserAtualDAO coduseratualDao() {
		return new CodUserAtualJDBC();
	}
	public UsuarioDAO usuarioDao() {
		return new UsuarioJDBC();
	}
	public UsuarioDAOLogin usuarioDaoLogin() {
		return new UsuarioJDBCLogin();
	}
	
	
	public PerguntasDAO perguntasDao() {
		return new PerguntasJDBC();
	}
	
	public PontuacaoDAO pontuacaoDao() {
		return new PontuacaoJDBC();
	}
	
	public PontosDAO pontosDao() {
		return new PontosJDBC();
	}
}
