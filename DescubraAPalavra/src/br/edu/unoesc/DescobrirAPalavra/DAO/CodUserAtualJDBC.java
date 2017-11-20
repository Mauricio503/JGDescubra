package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.DescobrirAPalavra.modelo.CodUserAtual;
import br.edu.unoesc.DescobrirAPalavra.modelo.Pontuacao;

public class CodUserAtualJDBC implements CodUserAtualDAO {

	@Override
	public List<CodUserAtual> listar() {
		List<CodUserAtual> coduseratual = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			Statement stmt = con.createStatement();
			String sql = "select * from cod_user_atual";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CodUserAtual coduser = new CodUserAtual();
				coduser.setCodigo(rs.getLong("codigo"));
				coduser.setCod_user_atual(rs.getLong("cod_user_atual"));
				coduseratual.add(coduser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coduseratual;
	}
	
	@Override
	public void inserir(CodUserAtual coduser) {
		try {
			Connection con = ConexaoUtil.getCon();
			String insert = "insert into cod_user_atual values(codigo,?)";
			PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setLong(1, coduser.getCod_user_atual());
			insertStmt.executeUpdate();
			ResultSet resultSet = insertStmt.getGeneratedKeys();
			resultSet.next();
			coduser.setCodigo(resultSet.getLong(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void alterar(CodUserAtual coduser) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "update cod_user_atual set cod_user_atual = ? where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, coduser.getCod_user_atual());
			updateStmt.setLong(2, coduser.getCodigo());			
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from cod_user_atual where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public CodUserAtual get(Long codigo) {
		CodUserAtual coduser = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from cod_user_atual where codigo = " + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			coduser = new CodUserAtual();
			coduser.setCodigo(rs.getLong("codigo"));
			coduser.setCod_user_atual(rs.getLong("cod_user_atual"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coduser;
	}



}
