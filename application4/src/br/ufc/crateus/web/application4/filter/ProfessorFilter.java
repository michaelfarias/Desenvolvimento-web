package br.ufc.crateus.web.application4.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/professor/*")
public class ProfessorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		if (httpReq.getSession().getAttribute("usuario") == null)
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

	public void destroy() {

	}
}
