package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.DescobrirAPalavra.modelo.Perguntas;

public class PerguntasJDBC implements PerguntasDAO{

	@Override
	public List<Perguntas> listar() {
		List<Perguntas> perguntas = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			Statement stmt = con.createStatement();
			String sql = "select * from perguntas";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Perguntas pergunta = new Perguntas();
				pergunta.setCodigo(rs.getLong("codigo"));
				pergunta.setAssunto(rs.getString("assunto"));
				pergunta.setPergunta1(rs.getString("pergunta1"));
				pergunta.setDica1perg1(rs.getString("dica1perg1"));
				pergunta.setDica2perg1(rs.getString("dica2perg1"));
				pergunta.setDica3perg1(rs.getString("dica3perg1"));
				pergunta.setRespperg1(rs.getString("respperg1"));
				pergunta.setPergunta2(rs.getString("pergunta2"));
				pergunta.setDica1perg2(rs.getString("dica1perg2"));
				pergunta.setDica2perg2(rs.getString("dica2perg2"));
				pergunta.setDica3perg2(rs.getString("dica3perg2"));
				pergunta.setRespperg2(rs.getString("respperg2"));
				pergunta.setPergunta3(rs.getString("pergunta3"));
				pergunta.setDica1perg3(rs.getString("dica1perg3"));
				pergunta.setDica2perg3(rs.getString("dica2perg3"));
				pergunta.setDica3perg3(rs.getString("dica3perg3"));
				pergunta.setRespperg3(rs.getString("respperg3"));
				pergunta.setPergunta4(rs.getString("pergunta4"));
				pergunta.setDica1perg4(rs.getString("dica1perg4"));
				pergunta.setDica2perg4(rs.getString("dica2perg4"));
				pergunta.setDica3perg4(rs.getString("dica3perg4"));
				pergunta.setRespperg4(rs.getString("respperg4"));
				pergunta.setPergunta5(rs.getString("pergunta5"));
				pergunta.setDica1perg5(rs.getString("dica1perg5"));
				pergunta.setDica2perg5(rs.getString("dica2perg5"));
				pergunta.setDica3perg5(rs.getString("dica3perg5"));
				pergunta.setRespperg5(rs.getString("respperg5"));
				perguntas.add(pergunta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perguntas;
	}
	
	@Override
	public void inserir(Perguntas perguntas) {
		try {
			Connection con = ConexaoUtil.getCon();
			String insert = "insert into perguntas(codigo,assunto,pergunta1,dica1perg1,dica2perg1,\r\n" + 
					"dica3perg1,respperg1,pergunta2,dica1perg2,dica2perg2,dica3perg2,respperg2,\r\n" + 
					"pergunta3,dica1perg3,dica2perg3,dica3perg3,respperg3,pergunta4,dica1perg4,\r\n" + 
					"dica2perg4,dica3perg4,respperg4,pergunta5,dica1perg5,dica2perg5,dica3perg5,\r\n" + 
					"respperg5) values(codigo,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, perguntas.getAssunto());
			insertStmt.setString(2, perguntas.getPergunta1());
			insertStmt.setString(3, perguntas.getDica1perg1());
			insertStmt.setString(4, perguntas.getDica2perg1());
			insertStmt.setString(5, perguntas.getDica3perg1());
			insertStmt.setString(6, perguntas.getRespperg1());
			insertStmt.setString(7, perguntas.getPergunta2());
			insertStmt.setString(8, perguntas.getDica1perg2());
			insertStmt.setString(9, perguntas.getDica2perg2());
			insertStmt.setString(10, perguntas.getDica3perg2());
			insertStmt.setString(11, perguntas.getRespperg2());
			insertStmt.setString(12, perguntas.getPergunta3());
			insertStmt.setString(13, perguntas.getDica1perg3());
			insertStmt.setString(14, perguntas.getDica2perg3());
			insertStmt.setString(15, perguntas.getDica3perg3());
			insertStmt.setString(16, perguntas.getRespperg3());
			insertStmt.setString(17, perguntas.getPergunta4());
			insertStmt.setString(18, perguntas.getDica1perg4());
			insertStmt.setString(19, perguntas.getDica2perg4());
			insertStmt.setString(20, perguntas.getDica3perg4());
			insertStmt.setString(21, perguntas.getRespperg4());
			insertStmt.setString(22, perguntas.getPergunta5());
			insertStmt.setString(23, perguntas.getDica1perg5());
			insertStmt.setString(24, perguntas.getDica2perg5());
			insertStmt.setString(25, perguntas.getDica3perg5());
			insertStmt.setString(26, perguntas.getRespperg5());
			insertStmt.executeUpdate();
			ResultSet resultSet = insertStmt.getGeneratedKeys();
			resultSet.next();
			perguntas.setCodigo(resultSet.getLong(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void alterar(Perguntas perguntas) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "update perguntas set assunto = ?,"
			+ " pergunta1 = ?,dica1perg1 = ?, dica2perg1 = ?,"
			+ " dica3perg1 = ?,respperg1 = ?, pergunta2 = ?, "
			+ " dica1perg2 = ?,dica2perg2 = ?,dica3perg2 = ?,"
			+ " respperg2 = ?, pergunta3 = ?,dica1perg3 = ?,"
			+ " dica2perg3 = ?,dica3perg3 = ?, respperg3 = ?,"
			+ " pergunta4 = ?,dica1perg4 = ?,dica2perg4 = ?,"
			+ " dica3perg4 = ?,respperg4 = ?, pergunta5 = ?,"
			+ " dica1perg5 = ?,dica2perg5 = ?,dica3perg5 = ?,"
			+ " respperg5 = ?, where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setString(1, perguntas.getAssunto());
			updateStmt.setString(2, perguntas.getPergunta1());
			updateStmt.setString(3, perguntas.getDica1perg1());
			updateStmt.setString(4, perguntas.getDica2perg1());
			updateStmt.setString(5, perguntas.getDica3perg1());
			updateStmt.setString(6, perguntas.getRespperg1());
			updateStmt.setString(7, perguntas.getPergunta2());
			updateStmt.setString(8, perguntas.getDica1perg2());
			updateStmt.setString(9, perguntas.getDica2perg2());
			updateStmt.setString(10, perguntas.getDica3perg2());
			updateStmt.setString(11, perguntas.getRespperg2());
			updateStmt.setString(12, perguntas.getPergunta3());
			updateStmt.setString(13, perguntas.getDica1perg3());
			updateStmt.setString(14, perguntas.getDica2perg3());
			updateStmt.setString(15, perguntas.getDica3perg3());
			updateStmt.setString(16, perguntas.getRespperg3());
			updateStmt.setString(17, perguntas.getPergunta4());
			updateStmt.setString(18, perguntas.getDica1perg4());
			updateStmt.setString(19, perguntas.getDica2perg4());
			updateStmt.setString(20, perguntas.getDica3perg4());
			updateStmt.setString(21, perguntas.getRespperg4());
			updateStmt.setString(22, perguntas.getPergunta5());
			updateStmt.setString(23, perguntas.getDica1perg5());
			updateStmt.setString(24, perguntas.getDica2perg5());
			updateStmt.setString(25, perguntas.getDica3perg5());
			updateStmt.setString(26, perguntas.getRespperg5());
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from perguntas where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public Perguntas get(Long codigo) {
		Perguntas perguntas = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from perguntas where codigo = " + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			perguntas = new Perguntas();
			perguntas.setCodigo(rs.getLong("codigo"));
			perguntas.setAssunto(rs.getString("assunto"));
			perguntas.setPergunta1(rs.getString("pergunta1"));
			perguntas.setDica1perg1(rs.getString("dica1perg1"));
			perguntas.setDica2perg1(rs.getString("dica2perg1"));
			perguntas.setDica3perg1(rs.getString("dica3perg1"));
			perguntas.setRespperg1(rs.getString("respperg1"));
			perguntas.setPergunta2(rs.getString("pergunta2"));
			perguntas.setDica1perg2(rs.getString("dica1perg2"));
			perguntas.setDica2perg2(rs.getString("dica2perg2"));
			perguntas.setDica3perg2(rs.getString("dica3perg2"));
			perguntas.setRespperg2(rs.getString("respperg2"));
			perguntas.setPergunta3(rs.getString("pergunta3"));
			perguntas.setDica1perg3(rs.getString("dica1perg3"));
			perguntas.setDica2perg3(rs.getString("dica2perg3"));
			perguntas.setDica3perg3(rs.getString("dica3perg3"));
			perguntas.setRespperg3(rs.getString("respperg3"));
			perguntas.setPergunta4(rs.getString("pergunta4"));
			perguntas.setDica1perg4(rs.getString("dica1perg4"));
			perguntas.setDica2perg4(rs.getString("dica2perg4"));
			perguntas.setDica3perg4(rs.getString("dica3perg4"));
			perguntas.setRespperg4(rs.getString("respperg4"));
			perguntas.setPergunta5(rs.getString("pergunta5"));
			perguntas.setDica1perg5(rs.getString("dica1perg5"));
			perguntas.setDica2perg5(rs.getString("dica2perg5"));
			perguntas.setDica3perg5(rs.getString("dica3perg5"));
			perguntas.setRespperg5(rs.getString("respperg5"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perguntas;
	}


	
}
