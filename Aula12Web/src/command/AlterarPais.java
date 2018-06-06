package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class AlterarPais implements Command  {
	
	@Override
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		
		int pId = Integer.parseInt(request.getParameter("id"));
		String pNome = request.getParameter("nome");
		Long pPopulacao = Long.parseLong(request.getParameter("populacao"));
		Double pArea = Double.parseDouble(request.getParameter("area"));
		String pContinente = request.getParameter("continente");
		
		Pais pais = new Pais();

		pais.setId(pId);
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		pais.setContinente(pContinente);
		
		PaisService paisservice = new PaisService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		Pais paisalt = paisservice.atualizar(pais);
		
		//pais = paisservice.carregar(pais.getId());
		
		session.setAttribute("paisalt", paisalt);
		view = request.getRequestDispatcher("PaisAlterado.jsp");
		
		view.forward(request, response);
	}

}



