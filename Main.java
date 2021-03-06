import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		iniciar(9000);

	}
	
	public static void iniciar(int porta) {
		
		ObjectOutputStream saida;
        ObjectInputStream entrada;
		
		try {
			ServerSocket serverSocket = new ServerSocket(porta);
			Socket conexao;
			Scanner scan = new Scanner(System.in);
			
			while (true) {

				System.out.println("servidor ativo na porta " + porta);

				//fica aberto aguardando alguma conexão
				conexao = serverSocket.accept();
				
				System.out.println("Conexão estabelecida com " + conexao.getInetAddress().getHostAddress());

				entrada = new ObjectInputStream(conexao.getInputStream());
				saida = new ObjectOutputStream(conexao.getOutputStream());
				Message message = (Message) entrada.readObject();
				
				saida.writeObject(message);
			}
			
		} catch (Exception e) {
		}
	}
}
