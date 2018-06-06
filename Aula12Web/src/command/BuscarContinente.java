package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;

import java.util.ArrayList;
import service.PaisService;

public class BuscarContinente implements Command  {
	
	@Override
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pCont = request.getParameter("continente");

		PaisService paisservice = new PaisService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ArrayList <Pais> continentelist = (ArrayList<Pais>) paisservice.listarContinente(pCont);
		session.setAttribute("continentelist", continentelist);
		view = request.getRequestDispatcher("ListarContinente.jsp");
		view.forward(request, response);

	}
}


