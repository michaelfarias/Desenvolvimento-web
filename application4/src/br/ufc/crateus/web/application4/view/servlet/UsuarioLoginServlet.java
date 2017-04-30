package br.ufc.crateus.web.application4.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application4.model.Usuario;
import br.ufc.crateus.web.application4.repository.AlunoRepositorio;
import br.ufc.crateus.web.application4.repository.ProfessorRepositorio;

@WebServlet("/login")
public class UsuarioLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Usuario usuario1, usuario2;
		usuario1 = ProfessorRepositorio.getInstance().getByLogin(login);
		usuario2 = AlunoRepositorio.getInstance().getByLogin(login);

		
		if (usuario1 != null && usuario1.getSenha().equals(senha)) {
			req.getSession().setAttribute("usuario",usuario1);
			getServletContext().getRequestDispatcher("/professor").forward(req, resp);
			
		}

		if (usuario2 != null && usuario2.getSenha().equals(senha)) {
			req.getSession().setAttribute("usuario", usuario2);
			
			getServletContext().getRequestDispatcher("/aluno").forward(req, resp);

		}

		if (((usuario2 != null && !usuario2.getSenha().equals(senha))
				&& (usuario1 != null && !usuario1.getSenha().equals(senha))) || usuario2 == null && usuario1 == null) {

			req.setAttribute("errorMessage", "Usuário ou senha inválidas!");
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		}

	}
}
