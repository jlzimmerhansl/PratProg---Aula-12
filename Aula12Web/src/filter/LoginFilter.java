package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/controller.do")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest reque = (HttpServletRequest) request;
		HttpSession session = reque.getSession();
		
		Usuario logado = (Usuario) session.getAttribute("logado");
		
		String path = reque.getContextPath();
		String uri = reque.getRequestURI();
		String comando = reque.getParameter("command");
		
		if(comando == null) {
			comando = "";
		}
		
		if((logado == null && !uri.equals(path + "/Login.jsp") && !comando.equals("Login")) && 
				(logado == null && !uri.equals(path + "/CadastrarUsuario.jsp") && !comando.equals("CadastrarUsuario"))) {
			
			((HttpServletResponse)response).sendRedirect(path + "/Login.jsp");
		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
