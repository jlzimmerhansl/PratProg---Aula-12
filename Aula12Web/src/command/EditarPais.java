package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;

import service.PaisService;

public class EditarPais implements Command  {
	
	@Override
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		
		int pVisu = Integer.parseInt(request.getParameter("id"));

		PaisService paisservice = new PaisService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		Pais pais = paisservice.carregar(pVisu);
		

		session.setAttribute("pais", pais);
		view = request.getRequestDispatcher("AlterarPais.jsp");
		
		view.forward(request, response);
		
	}

}


