import java.io.Serializable;

public class Message implements Serializable{
	
	private String nome;
	private String message;
	private Boolean isFim;

	public String getNome() {
		return nome;
	}
	
	public Boolean isFim() {
		return isFim;
	}

	public void setFim(Boolean isFim) {
		this.isFim = isFim;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
