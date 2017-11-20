package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.DescobrirAPalavra.modelo.Pontuacao;

public class PontuacaoJDBC implements PontuacaoDAO {
	
	@Override
	public List<Pontuacao> listar() {
		List<Pontuacao> pontuacoes = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			Statement stmt = con.createStatement();
			String sql = "select * from pontuacao";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pontuacao pontuacao = new Pontuacao();
				pontuacao.setCodigo(rs.getLong("codigo"));
				pontuacao.setPontos(rs.getLong("pontos"));
				pontuacao.setCodusuario(rs.getLong("codusuario"));
				pontuacao.setQtd_perguntas(rs.getInt("qtd_perguntas"));
				pontuacao.setAssunto(rs.getString("assunto"));
				pontuacoes.add(pontuacao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pontuacoes;
	}
	@Override
	public void inserir(Pontuacao pontuacao) {
		try {
			Connection con = ConexaoUtil.getCon();
			String insert = "insert into pontuacao(codigo,pontos,codusuario,assunto)"
					+ " values(codigo,?,?,?)";
			PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setLong(1, pontuacao.getPontos());
			insertStmt.setLong(2, pontuacao.getCodusuario());
			insertStmt.setString(3, pontuacao.getAssunto());
			insertStmt.executeUpdate();
			ResultSet resultSet = insertStmt.getGeneratedKeys();
			resultSet.next();
			pontuacao.setCodigo(resultSet.getLong(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void alterar(Pontuacao pontuacao) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "update pontuacao set pontos = ?,"
			+ "codusuario = ?, assunto = ? where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, pontuacao.getPontos());
			updateStmt.setLong(2, pontuacao.getCodusuario());
			updateStmt.setString(3, pontuacao.getAssunto());
			updateStmt.setLong(4, pontuacao.getCodigo());			
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from pontuacao where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Pontuacao get(Long codigo) {
		Pontuacao pontuacao = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from pontuacao where codigo = " + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			pontuacao = new Pontuacao();
			pontuacao.setCodigo(rs.getLong("codigo"));
			pontuacao.setPontos(rs.getLong("pontos"));
			pontuacao.setQtd_perguntas(rs.getInt("qtd_perguntas"));
			pontuacao.setAssunto(rs.getString("assunto"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pontuacao;
	}


}
