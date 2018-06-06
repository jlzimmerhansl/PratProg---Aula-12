package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;

import java.util.List;

import service.PaisService;

public class ListarPais implements Command  {
	
	@Override
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PaisService paisservice = new PaisService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		List <Pais> paiseslist = paisservice.listar();
		
		session.setAttribute("paiseslist", paiseslist);
		view = request.getRequestDispatcher("ListarPaises.jsp");
		view.forward(request, response);

}

}


