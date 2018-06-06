package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class CriarPais implements Command  {
	
	@Override
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		String pNome = request.getParameter("nome");
		Long pPopulacao = Long.parseLong(request.getParameter("populacao"));
		Double pArea = Double.parseDouble(request.getParameter("area"));
		String pContinente = request.getParameter("continente");
		
		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		pais.setContinente(pContinente);
		
		PaisService paisservice = new PaisService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		paisservice.criar(pais);

		pais = paisservice.carregar(pais.getId());
		System.out.println(pais);
		session.setAttribute("pais", pais);
		view = request.getRequestDispatcher("Pais.jsp");
		
		view.forward(request, response);
		
		
	}


}

