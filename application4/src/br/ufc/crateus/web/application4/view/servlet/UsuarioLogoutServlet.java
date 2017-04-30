package br.ufc.crateus.web.application4.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class UsuarioLogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 5875451523178967525L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().removeAttribute("usuario");
		getServletContext().getRequestDispatcher("/").forward(req, resp);
	}
}
