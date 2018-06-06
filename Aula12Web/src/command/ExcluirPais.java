package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.PaisService;

public class ExcluirPais implements Command  {
	
	@Override
	
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

		int pId = Integer.parseInt(request.getParameter("id"));
		System.out.println(pId);
		
		PaisService paisservice = new PaisService();

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		paisservice.excluir(pId);

		//session.setAttribute("pais", pais);
		request.getRequestDispatcher("PaisExcluido.jsp").forward(request, response);
	}

}






