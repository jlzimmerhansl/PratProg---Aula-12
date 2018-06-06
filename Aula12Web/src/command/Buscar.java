package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;

import service.PaisService;

public class Buscar implements Command  {
	
	@Override
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		
		String pBuscaPais = request.getParameter("nome");

		PaisService paisservice = new PaisService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		Pais buscapais = paisservice.buscar(pBuscaPais);
		
		session.setAttribute("buscapais", buscapais);
		view = request.getRequestDispatcher("BuscarPaises.jsp");
		view.forward(request, response);

	}

}

