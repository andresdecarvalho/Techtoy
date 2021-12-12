package br.edu.unicid.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import br.edu.unicid.bean.Categoria;
import br.edu.unicid.bean.Produto;
import br.edu.unicid.util.ConnectionFactory;

public class ProdutoDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Produto produto;

	public ProdutoDao() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar
	public void salvar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO Produto (idProduto, nomeProduto, descProduto, fotoProduto, precoProduto, codCategoria) values (?, ?, ?, ?, ?, ?)";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, produto.getIdProduto());
			ps.setString(2, produto.getNomeProduto());
			ps.setString(3, produto.getDescProduto());
			ps.setString(4, produto.getFotoProduto());
			ps.setDouble(5, produto.getPrecoProduto());
			ps.setInt(6, produto.getCodCategoria());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de atualizar
	public void atualizar(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE Produto set nomeProduto=?, descProduto=?, fotoProduto=?, precoProduto=?, codCategoria=? WHERE idProduto=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setString(1, produto.getNomeProduto());
			ps.setString(2, produto.getDescProduto());
			ps.setString(3, produto.getFotoProduto());
			ps.setDouble(4, produto.getPrecoProduto());
			ps.setInt(5, produto.getCodCategoria());
			ps.setInt(6, produto.getIdProduto());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// método de excluir
	public void excluir(Produto produto) throws Exception {
		if (produto == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM Produto WHERE idProduto = ?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, produto.getIdProduto());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	// procurar categoria
	public Produto procurarProduto(int idProduto) throws Exception {

		try {
			String SQL = "SELECT * FROM Produto WHERE idProduto=?";
			conn = this.conn;
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idProduto);
			rs = ps.executeQuery();
			if (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String foto = rs.getString(4);
				Double preco = rs.getDouble(5);
				int categoria = rs.getInt(6);

				produto = new Produto(codigo, nome, descricao, foto, preco, categoria);
			}
			return produto;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	// listar todos os categorias
	public List todosProdutos() throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM Produto");
			rs = ps.executeQuery();
			List<Produto> list = new ArrayList<Produto>();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String foto = rs.getString(4);
				Double preco = rs.getDouble(5);
				int categoria = rs.getInt(6);
				list.add(new Produto(codigo, nome, descricao, foto, preco, categoria));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}

	public List filtroProdutos(String codCategoria) throws Exception {
		try {
			conn = this.conn;
			ps = conn.prepareStatement("SELECT * FROM Produto WHERE codCategoria = " + codCategoria);
			rs = ps.executeQuery();
			List<Produto> list = new ArrayList<Produto>();
			while (rs.next()) {
				int codigo = rs.getInt(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String foto = rs.getString(4);
				Double preco = rs.getDouble(5);
				int categoria = rs.getInt(6);
				list.add(new Produto(codigo, nome, descricao, foto, preco, categoria));
			}
			return list;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}
