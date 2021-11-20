import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorTCP {

	public static void main(String[] args) {
		iniciar(9000);

	}
	
	public static void iniciar(int porta) {
		
		ObjectOutputStream saida;
        ObjectInputStream entrada;
		Boolean isFirstTime = true;
		
		try {
			ServerSocket serverSocket = new ServerSocket(porta);
			Socket conexao;
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				if(isFirstTime) System.out.println("servidor ativo na porta " + porta);

				//fica aberto aguardando alguma conexão
				conexao = serverSocket.accept();
					
				if(isFirstTime)	System.out.println("Conexão estabelecida com " + conexao.getInetAddress().getHostAddress());

				isFirstTime = false;
				
				entrada = new ObjectInputStream(conexao.getInputStream());
				saida = new ObjectOutputStream(conexao.getOutputStream());
				Message message = (Message) entrada.readObject();
				
				try {
					System.out.println("Pessoa 1: " + message.getMessage());

					System.out.println("Digite sua Mensagem");
					message.setMessage(scan.next());						

					saida.writeObject(message);
				} catch (Exception e) {
					//ToDo
				}			
			}
			
		} catch (Exception e) {
		}
	}
}
