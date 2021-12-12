package br.edu.unicid.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import br.edu.unicid.bean.Categoria;
import br.edu.unicid.util.ConnectionFactory;

public class CategoriaDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Categoria categoria;

	public CategoriaDao() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO Categoria (codCategoria, nomeCategoria, linhaCategoria, faixaCategoria) values (?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, categoria.getCodCategoria());
			ps.setString(2, categoria.getNomeCategoria());
			ps.setString(3, categoria.getLinhaCategoria());	
			ps.setString(4, categoria.getFaixaCategoria());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE Categoria set nomeCategoria=?, linhaCategoria=?, faixaCategoria=? WHERE codCategoria=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, categoria.getNomeCategoria());
			ps.setString(2, categoria.getLinhaCategoria());
			ps.setString(3, categoria.getFaixaCategoria());
			ps.setInt(4, categoria.getCodCategoria());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Categoria categoria) throws Exception {
		if (categoria == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM Categoria WHERE codCategoria = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, categoria.getCodCategoria());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// procurar categoria
	public Categoria procurarCategoria(int codCategoria) throws Exception {

		try {
			String SQL = "SELECT  * FROM Categoria WHERE codCategoria=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, codCategoria);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String linha = rs.getString(3);
				String faixa = rs.getString(4);

				categoria = new Categoria(codigo, nome, linha, faixa);
			}
			return categoria;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// listar todos os categorias
	public List todosCategorias() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM Categoria");
			rs = ps.executeQuery();
			List<Categoria> list = new ArrayList<Categoria>();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String linha = rs.getString(3);			
				String faixa = rs.getString(4);
				list.add(new Categoria(codigo, nome, linha, faixa));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}
