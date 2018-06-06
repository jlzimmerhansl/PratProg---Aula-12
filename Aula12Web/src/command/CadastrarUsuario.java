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

import crypto.CryptoAES;
import model.Usuario;
import service.UsuarioService;

public class CadastrarUsuario implements Command { 
	
	
	@Override 
	public void executar(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException { 
	
		UsuarioService usuarioservice = new UsuarioService();
		Usuario usuario = new Usuario();
		
		String pUsername = request.getParameter("username");
		String pPassword = request.getParameter("password");
		
		byte[] bSenhaClara = null;
		String sSenhaCifrada = null;
		byte[] bSenhaCifrada = null;
		bSenhaClara = pPassword.getBytes("ISO-8859-1");

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
			System.out.println(bSenhaCifrada);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Converte o texto byte[] no equivalente String
		sSenhaCifrada = (new String(bSenhaCifrada, "ISO-8859-1"));
		
		usuario.setUsername(pUsername);
		usuario.setPassword(sSenhaCifrada);
	
		usuarioservice.cadastrar(usuario);
		
	    request.setAttribute("usuario", usuario); 
	    
        RequestDispatcher view = request.getRequestDispatcher("UsuarioCadastrado.jsp");
        view.forward(request, response);

	}
		
}