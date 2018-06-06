package command;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crypto.CryptoAES;
import model.Usuario;
import service.UsuarioService;

public class Login implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		System.out.println("username");
		String password = request.getParameter("password");

		byte[] bSenhaClara = null;
		String sSenhaCifrada = null;
		byte[] bSenhaCifrada = null;
		bSenhaClara = password.getBytes("ISO-8859-1");

		// Instancia um objeto da classe CryptoAES
		CryptoAES caes = new CryptoAES();
		
		/*try {
			caes.geraChave(new File("chave.simetrica"));
			System.out.println("gerei a chave");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		// Gera a cifra AES da mensagem dada, com a chave simetrica dada
		try {
			System.out.println("gerei a cifra");
			caes.geraCifra(bSenhaClara, new File("chave.simetrica"));
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException | InvalidAlgorithmParameterException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Recebe o texto cifrado
		try {
			System.out.println("texto cifrado");
			bSenhaCifrada = caes.getTextoCifrado();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Converte o texto byte[] no equivalente String
		sSenhaCifrada = (new String(bSenhaCifrada, "ISO-8859-1"));

		Usuario usuario = new Usuario();

		usuario.setUsername(username);
		usuario.setPassword(sSenhaCifrada);

		UsuarioService usuarioservice = new UsuarioService();

		if (usuarioservice.validar(usuario)) {
			System.out.println("senha correta");
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("Logou " + usuario);
			

		} else {

			System.out.println("Não Logou " + usuario);
			throw new ServletException("Usuário/Senha inválidos");

		}

		String mensagem = "Sim";
		
		request.setAttribute("mensagem", mensagem);

		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);

	}

}