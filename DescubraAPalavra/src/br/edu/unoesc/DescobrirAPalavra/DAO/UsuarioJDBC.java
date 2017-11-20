package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.DescobrirAPalavra.modelo.Usuario;


public class UsuarioJDBC implements UsuarioDAO{

	
	
	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		try {
			Connection con = ConexaoUtil.getCon();
			Statement stmt = con.createStatement();
			String sql = "select * from usuario";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCodigo(rs.getLong("codigo"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	@Override
	public void inserir(Usuario usuario) {
		try {
			Connection con = ConexaoUtil.getCon();
			String insert = "insert into usuario values(codigo,?,?)";
			PreparedStatement insertStmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, usuario.getUsuario());
			insertStmt.setString(2, usuario.getSenha());
			insertStmt.executeUpdate();
			ResultSet resultSet = insertStmt.getGeneratedKeys();
			resultSet.next();
			usuario.setCodigo(resultSet.getLong(1));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void alterar(Usuario usuario) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "update usuario set usuario = ?," + " senha = ? where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setString(1, usuario.getUsuario());
			updateStmt.setString(2, usuario.getSenha());
			updateStmt.setLong(3, usuario.getCodigo());
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void excluir(Long codigo) {
		try {
			Connection con = ConexaoUtil.getCon();
			String update = "delete from usuario where codigo = ? ";
			PreparedStatement updateStmt = con.prepareStatement(update);
			updateStmt.setLong(1, codigo);
			updateStmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Usuario get(Long codigo) {
		Usuario usuario = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from usuario where codigo = " + codigo;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			usuario = new Usuario();
			usuario.setCodigo(rs.getLong("codigo"));
			usuario.setUsuario(rs.getString("usuario"));
			usuario.setSenha(rs.getString("senha"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	
}
