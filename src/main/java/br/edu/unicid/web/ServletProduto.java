package br.edu.unicid.web;

import java.io.IOException;
import java.util.List;

import br.edu.unicid.bean.Categoria;
import br.edu.unicid.bean.Produto;
import br.edu.unicid.dao.CategoriaDao;
import br.edu.unicid.dao.ProdutoDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
		String cmd = request.getParameter("cmd");
		String codCategoria = request.getParameter("codCategoria");
		String idProduto = request.getParameter("idProduto");
		// cria um objeto dao - CRUD
		ProdutoDao dao;
		CategoriaDao Categoriadao;
		// cria um objeto do tipo categoria
		Produto produto = new Produto();
		if (cmd != null) {
			try {
				// inicializa os atributos da classe Categorias
				produto.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));
				produto.setNomeProduto(request.getParameter("nomeProduto"));
				produto.setDescProduto(request.getParameter("descProduto"));
				produto.setFotoProduto(request.getParameter("fotoProduto"));
				produto.setPrecoProduto(Double.parseDouble(request.getParameter("precoProduto")));
				produto.setCodCategoria(Integer.parseInt(request.getParameter("codCategoria")));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		try {
			// cria a instancia do objeto dao
			dao = new ProdutoDao();
			Categoriadao = new CategoriaDao();
			RequestDispatcher rd = null;
			// lista todos os categorias
			if (cmd.equalsIgnoreCase("listar")) {
				List<Produto> produtosList;				
					produtosList = dao.todosProdutos();
				//List<Categoria> categoriaList = Categoriadao.todosCategorias();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("produtosList", produtosList);
				//request.setAttribute("categoriaList", categoriaList);
				// redireciona para a JSP mostraCategoriasCads
				rd = request.getRequestDispatcher("/mostrarProdutosCads.jsp");
			}
			if (cmd.equalsIgnoreCase("filtrar")) {
				List<Produto> produtosList;
				if (codCategoria == null) {
					produtosList = dao.todosProdutos();
				}
				else {
					produtosList = dao.filtroProdutos(codCategoria);
				}
				//List<Categoria> categoriaList = Categoriadao.todosCategorias();
				// cria uma sessão para encaminhar a lista para uma JSP
				request.setAttribute("produtosList", produtosList);
				//request.setAttribute("categoriaList", categoriaList);
				// redireciona para a JSP mostraCategoriasCads
				rd = request.getRequestDispatcher("/filtrarProduto.jsp");
			}

			// incluir categoria
			else if (cmd.equalsIgnoreCase("incluir")) {
				dao.salvar(produto);
				rd = request.getRequestDispatcher("ServletProduto?cmd=listar");

				// consulta categoria para exclusão
			 } else if (cmd.equalsIgnoreCase("exc")) {
                produto = dao.procurarProduto(Integer.parseInt(idProduto));
                HttpSession session = request.getSession(true);
                session.setAttribute("produto", produto);
                rd = request.getRequestDispatcher("/formExcProduto.jsp");
             
            // exclui categoria
            } else if (cmd.equalsIgnoreCase("excluir")) {
                dao.excluir(produto);
                rd = request.getRequestDispatcher("ServletProduto?cmd=listar");

				// consulta categoria para alteração
			} else if (cmd.equalsIgnoreCase("atu")) {
				produto = dao.procurarProduto(Integer.parseInt(idProduto));
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);
				rd = request.getRequestDispatcher("/formAttProduto.jsp");

				// consulta categoria
			} else if (cmd.equalsIgnoreCase("con")) {
				produto = dao.procurarProduto(produto.getIdProduto());
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);
				rd = request.getRequestDispatcher("/formConProduto.jsp");
				
			} else if (cmd.equalsIgnoreCase("descricao")) {
				produto = dao.procurarProduto(produto.getIdProduto());
				HttpSession session = request.getSession(true);
				session.setAttribute("produto", produto);
				rd = request.getRequestDispatcher("/formConProduto2.jsp");

				// altera categoria
			} else if (cmd.equalsIgnoreCase("atualizar")) {
				dao.atualizar(produto);
				rd = request.getRequestDispatcher("ServletProduto?cmd=listar");

				// direciona para a página principal
			} else if (cmd.equalsIgnoreCase("principal")) {
				rd = request.getRequestDispatcher("/index.jsp");
			}
			// executa a ação de direcionar para a página JSP
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}