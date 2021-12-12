package br.edu.unicid.web;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.unicid.bean.Usuario;
import br.edu.unicid.dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {

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
			String codigoUsuario = request.getParameter("codUsuario");
	        // cria um objeto dao - CRUD
	        UsuarioDao dao;
	        // cria um objeto do tipo usuario
	        Usuario usuario = new Usuario();
	        if (cmd != null) {
	            try {
	                // inicializa os atributos da classe Usuarios
	            	usuario.setCodUsuario(Integer.parseInt(request.getParameter("codUsuario")));  
	            	usuario.setNomeUsuario(request.getParameter("nomeUsuario"));
	                usuario.setEmailUsuario(request.getParameter("emailUsuario"));
	                usuario.setSenhaUsuario(request.getParameter("senhaUsuario"));
                } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	        try {
	        	// cria a instancia do objeto dao
	            dao = new UsuarioDao();
	            RequestDispatcher rd = null;
	            // lista todos os usuarios
	            if (cmd.equalsIgnoreCase("listar")) {
	                List<Usuario> usuariosList = dao.todosUsuarios();
	                // cria uma sessão para encaminhar a lista para uma JSP
	                request.setAttribute("usuariosList", usuariosList);
	                // redireciona para a JSP mostraUsuariosCads
	                rd = request.getRequestDispatcher("/mostrarUsuariosCads.jsp");
	            }
	            
	            // incluir usuario
	            else if (cmd.equalsIgnoreCase("incluir")) {
	                dao.salvar(usuario);
	                rd = request.getRequestDispatcher("ServletUsuario?cmd=listar");
	             
	            // consulta usuario para exclusão    
	            } else if (cmd.equalsIgnoreCase("exc")) {
	                usuario = dao.procurarUsuario(Integer.parseInt(codigoUsuario));
	                HttpSession session = request.getSession(true);
	                session.setAttribute("usuario", usuario);
	                rd = request.getRequestDispatcher("/formExcUsuario.jsp");
	             
	            // exclui usuario
	            } else if (cmd.equalsIgnoreCase("excluir")) {
	                dao.excluir(usuario);
	                rd = request.getRequestDispatcher("ServletUsuario?cmd=listar");
	            
	            // consulta usuario para alteração
	            }  else if (cmd.equalsIgnoreCase("atu")) {
	                usuario = dao.procurarUsuario(Integer.parseInt(codigoUsuario));
	                HttpSession session = request.getSession(true);
	                session.setAttribute("usuario", usuario);
	                rd = request.getRequestDispatcher("/formAttUsuario.jsp");
	             
	            // consulta usuario
	            } else if (cmd.equalsIgnoreCase("con")) {
	                usuario = dao.procurarUsuario(usuario.getCodUsuario());
	                HttpSession session = request.getSession(true);
	                session.setAttribute("usuario", usuario);
	                rd = request.getRequestDispatcher("/formConUsuario.jsp");
	                
	             // altera usuario    
	            } else if (cmd.equalsIgnoreCase("atualizar")) {
	                dao.atualizar(usuario);
	                rd = request.getRequestDispatcher("ServletUsuario?cmd=listar");
	            
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