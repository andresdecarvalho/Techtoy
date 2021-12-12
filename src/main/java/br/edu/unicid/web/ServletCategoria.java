package br.edu.unicid.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.unicid.bean.Categoria;
import br.edu.unicid.dao.CategoriaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ServletCategoria")
public class ServletCategoria extends HttpServlet {

	 private Date strToDate(String data) throws Exception {
	        if (data == null) {
	            return null;
	        }

	        Date dataF = null;
	        try {
	            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	            long timestamp = dateFormat.parse(data).getTime();
	            dataF = new Date(timestamp);
	        } catch (ParseException pe) {
	            throw pe;
	        }
	        return dataF;
	    }

	    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        // a variável cmd indica o tipo de ação - incluir, alterar, consulta.....
	        String cmd = request.getParameter("cmd");
	        String codigoCategoria = request.getParameter("codCategoria");
	        // cria um objeto dao - CRUD
	        CategoriaDao dao;
	        // cria um objeto do tipo categoria
	        Categoria categoria = new Categoria();
	        if (cmd != null) {
	            try {
	                // inicializa os atributos da classe Categorias
	            	categoria.setCodCategoria(Integer.parseInt(request.getParameter("codCategoria")));  
	            	categoria.setNomeCategoria(request.getParameter("nomeCategoria"));
	                categoria.setLinhaCategoria(request.getParameter("linhaCategoria"));
	                categoria.setFaixaCategoria(request.getParameter("faixaCategoria"));
                } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	        try {
	        	// cria a instancia do objeto dao
	            dao = new CategoriaDao();
	            RequestDispatcher rd = null;
	            // lista todos os categorias
	            if (cmd.equalsIgnoreCase("listar")) {
	                List<Categoria> categoriasList = dao.todosCategorias();
	                // cria uma sessão para encaminhar a lista para uma JSP
	                request.setAttribute("categoriasList", categoriasList);
	                // redireciona para a JSP mostraCategoriasCads
	                rd = request.getRequestDispatcher("/mostrarCategoriasCads.jsp");
	            }
	            
	            // incluir categoria
	            else if (cmd.equalsIgnoreCase("incluir")) {
	                dao.salvar(categoria);
	                rd = request.getRequestDispatcher("ServletCategoria?cmd=listar");
	             
	            // consulta categoria para exclusão    
	            } else if (cmd.equalsIgnoreCase("exc")) {
	                categoria = dao.procurarCategoria(Integer.parseInt(codigoCategoria));
	                HttpSession session = request.getSession(true);
	                session.setAttribute("categoria", categoria);
	                rd = request.getRequestDispatcher("/formExcCategoria.jsp");
	             
	            // exclui categoria
	            } else if (cmd.equalsIgnoreCase("excluir")) {
	                dao.excluir(categoria);
	                rd = request.getRequestDispatcher("ServletCategoria?cmd=listar");
	            
	            // consulta categoria para alteração
	            }  else if (cmd.equalsIgnoreCase("atu")) {
	                categoria = dao.procurarCategoria(Integer.parseInt(codigoCategoria));
	                HttpSession session = request.getSession(true);
	                session.setAttribute("categoria", categoria);
	                rd = request.getRequestDispatcher("/formAttCategoria.jsp");
	             
	            // consulta categoria
	            } else if (cmd.equalsIgnoreCase("con")) {
	                categoria = dao.procurarCategoria(categoria.getCodCategoria());
	                HttpSession session = request.getSession(true);
	                session.setAttribute("categoria", categoria);
	                rd = request.getRequestDispatcher("/formConCategoria.jsp");
	            
	             // altera categoria    
	            } else if (cmd.equalsIgnoreCase("atualizar")) {
	                dao.atualizar(categoria);
	                rd = request.getRequestDispatcher("ServletCategoria?cmd=listar");
	            
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