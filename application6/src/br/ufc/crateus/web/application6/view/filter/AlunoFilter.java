package br.ufc.crateus.web.application6.view.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.ufc.crateus.web.application6.model.Aluno;

@WebFilter("/aluno/*")
public class AlunoFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;

		if (httpReq.getSession().getAttribute("usuario") instanceof Aluno)
			chain.doFilter(req, resp);
		else
			req.getRequestDispatcher("/index.jsp").forward(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
