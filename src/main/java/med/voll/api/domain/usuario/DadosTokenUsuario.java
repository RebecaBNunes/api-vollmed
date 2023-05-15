package med.voll.api.domain.usuario;

public record DadosTokenUsuario(String token) {

	public DadosTokenUsuario(String token) {
		this.token = token;
	}
	
}
