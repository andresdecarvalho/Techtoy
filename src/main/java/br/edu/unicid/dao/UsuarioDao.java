package br.edu.unicid.dao;

import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

import br.edu.unicid.bean.Usuario;
import br.edu.unicid.util.ConnectionFactory;

public class UsuarioDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Usuario usuario;

	public UsuarioDao() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO Usuario (codUsuario, nomeUsuario, emailUsuario, senhaUsuario) values (?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, usuario.getCodUsuario());
			ps.setString(2, usuario.getNomeUsuario());
			ps.setString(3, usuario.getEmailUsuario());	
			ps.setString(4, usuario.getSenhaUsuario());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE Usuario set nomeUsuario=?, emailUsuario=?, senhaUsuario=? WHERE codUsuario=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, usuario.getNomeUsuario());
			ps.setString(2, usuario.getEmailUsuario());
			ps.setString(3, usuario.getSenhaUsuario());
			ps.setInt(4, usuario.getCodUsuario());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Usuario usuario) throws Exception {
		if (usuario == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM Usuario WHERE codUsuario = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, usuario.getCodUsuario());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// procurar usuario
	public Usuario procurarUsuario(int codUsuario) throws Exception {

		try {
			String SQL = "SELECT  * FROM Usuario WHERE codUsuario=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, codUsuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String senha = rs.getString(4);

				usuario = new Usuario(codigo, nome, email, senha);
			}
			return usuario;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// listar todos os usuarios
	public List todosUsuarios() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM Usuario");
			rs = ps.executeQuery();
			List<Usuario> list = new ArrayList<Usuario>();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);			
				String senha = rs.getString(4);
				list.add(new Usuario(codigo, nome, email, senha));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

		
}
	

