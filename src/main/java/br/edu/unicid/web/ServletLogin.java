package br.edu.unicid.web;

import java.io.IOException;

import br.edu.unicid.bean.Login;
import br.edu.unicid.dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String nome = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senhaUsuario");
        Login loginBean = new Login();
        loginBean.setNomeUsuario(nome);
        loginBean.setSenhaUsuario(senha);

        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                session.setAttribute("nomeUsuario",nome);
                response.sendRedirect("areaadministrativa.jsp");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("nomeUsuario",nome);
                response.sendRedirect("erro.jsp");
                //System.out.println("Erro");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}