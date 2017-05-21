package br.ufc.crateus.web.application6.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application6.model.Aluno;
import br.ufc.crateus.web.application6.model.Professor;
import br.ufc.crateus.web.application6.model.Usuario;
import br.ufc.crateus.web.application6.persistence.UsuarioManager;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 675438712800289952L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = UsuarioManager.getUsuario(req.getParameter("login"), req.getParameter("senha"));

		if (usuario != null) {
			req.getSession().setAttribute("usuario", usuario);

			if (usuario instanceof Professor)
				getServletContext().getRequestDispatcher("/professor").forward(req, resp);

			if (usuario instanceof Aluno)
				getServletContext().getRequestDispatcher("/aluno").forward(req, resp);

		} else {

			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}
