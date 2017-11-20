package br.edu.unoesc.DescobrirAPalavra.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.DescobrirAPalavra.modelo.Usuario;

public class UsuarioJDBCLogin implements UsuarioDAOLogin{

	@Override
	public List<Usuario> listarlogin() {
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
	public Usuario get(String usuario) {
		Usuario nome = null;
		try {
			Connection con = ConexaoUtil.getCon();
			// Classe que sabe executar comandos SQL
			Statement stmt = con.createStatement();
			// Comando sql que desejo executar
			String sql = "select * from usuario where "+usuario;
			// Execução do comando e o resultado é
			// armazenado no ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			nome = new Usuario();
			nome.setCodigo(rs.getLong("codigo"));
			nome.setUsuario(rs.getString("usuario"));
			nome.setSenha(rs.getString("senha"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nome;
	}

	

}
