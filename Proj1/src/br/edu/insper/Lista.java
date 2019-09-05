package br.edu.insper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/lista")
public class Lista extends HttpServlet {
	 protected void service(HttpServletRequest request,
	 HttpServletResponse response)
		 throws ServletException, IOException {
		DAO dao = new DAO();
		List<Note> notes = dao.getListaNote();
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>Title</td><td>Content</td>" +
		 "<td>User Id</td></tr>");
		for (Note note : notes) {
		 out.println("<tr><td>" + note.getTitle() + "</td>");
		 out.println("<td>" + note.getContent() + "</td>");
		 out.println("<td>" + note.getUserId() + "</td>");

		}
		out.println("</table></body></html>"); 
		
		dao.close();

 }
}