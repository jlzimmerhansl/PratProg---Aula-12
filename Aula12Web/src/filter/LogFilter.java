package filter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Usuario;
import utils.Log;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LogFilter implements Filter {

    FilterConfig filterConfig = null;
    
	public void destroy() {

	}


	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest reque = (HttpServletRequest) request;
		HttpSession session = reque.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("logado");
		
		String comando = reque.getParameter("command");
	
		if(comando == null) {
			comando = reque.getRequestURI();
		}
		
		Calendar timestamp = Calendar.getInstance();
		String textoLog = "";
		ServletContext servletContext = filterConfig.getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		
		if(usuario == null) {
			textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s\n",
							timestamp, comando);
		}else {
			textoLog = String
					.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s -> %s\n",
							timestamp, usuario.getUsername(), comando);
		}
		
		synchronized (textoLog) {
			Log arquivoLog = new Log();
			
			arquivoLog.abrir(contextPath + "log" + File.separator + Log.NOME);
			arquivoLog.escrever(textoLog);
			arquivoLog.fechar();
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
