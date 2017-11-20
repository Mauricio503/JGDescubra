package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.DescobrirAPalavra.modelo.CodUserAtual;
import br.edu.unoesc.DescobrirAPalavra.modelo.Pontuacao;

public class PontosJDBC implements PontosDAO {

    
	private CodUserAtualDAO coduseratualDao = DaoFactory.get().coduseratualDao();
	private CodUserAtual coduseratual = new CodUserAtual();
	private long coduser;
	
	List<CodUserAtual> listcoduseratual = coduseratualDao.listar();
	CodUserAtual getcoduseratual = listcoduseratual.get(0);
	
	@Override
	public List<Pontuacao> listarpontos() {
		coduseratual.setCod_user_atual(getcoduseratual.getCod_user_atual());
		coduser=coduseratual.getCod_user_atual();
		List<Pontuacao> pontuacao = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			Statement stmt = con.createStatement();
			String sql = "select * from pontuacao where codusuario ="+coduser;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pontuacao pontos = new Pontuacao();
				pontos.setCodigo(rs.getLong("codigo"));
				pontos.setCodusuario(rs.getLong("codusuario"));
				pontos.setPontos(rs.getLong("pontos"));
				pontos.setAssunto(rs.getString("assunto"));
				pontos.setData(rs.getString("datacadastro"));
				pontuacao.add(pontos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pontuacao;
	}

	@Override
	public Pontuacao get(String codusuario) {
		Pontuacao pontos = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from pontuacao where "+codusuario;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			pontos = new Pontuacao();
			pontos.setCodigo(rs.getLong("codigo"));
			pontos.setPontos(rs.getLong("pontos"));
			pontos.setCodusuario(rs.getLong("codusuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pontos;
	}

}
