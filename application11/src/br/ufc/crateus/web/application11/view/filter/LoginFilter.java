package br.ufc.crateus.web.application11.view.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.ufc.crateus.web.application11.view.bean.LoginBean;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) req).getSession();
		LoginBean loginBean = (LoginBean) session.getAttribute("loginBean");
		if (loginBean != null && loginBean.getUsuario() != null) {
			System.out.println("Autorizado para: " + loginBean.getUsuario());
			filter.doFilter(req, res);
		} else {
			System.out.println("Não autorizado");
			req.getRequestDispatcher("/login.jsf?faces-redirect=true").forward(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
