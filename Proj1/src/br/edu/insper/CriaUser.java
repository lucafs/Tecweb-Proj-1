package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cria")
public class CriaUser extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
 PrintWriter out = response.getWriter();
	out.println("<html><body>");
	out.println("<form method='post'>");
	out.println("Nome: <input type='text' name='nome'><br>");
	out.println("Senha: <input type='text' name='senha'><br>");
	out.println("<input type='submit' value='Submit'>");
	out.println("</form>");
	out.println("<body><html>");
 }
 @Override
 protected void doPost(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
	 DAO dao = new DAO();
	 User user = new User();
	 user.setNome(request.getParameter("nome"));
	 user.setSenha(request.getParameter("senha"));
	 dao.adicionaUser(user);
	 PrintWriter out = response.getWriter();
		 out.println("<html><body>");
		 out.println("Adicionado " + user.getNome());
		 out.println("</body></html>");
		 dao.close();
	 }
}