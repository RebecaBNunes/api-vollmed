package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
		@NotBlank String logradouro, 
		@NotBlank String bairro,
		@NotBlank @Pattern(regexp = "\\d{8}") String cep,
		@NotBlank String cidade,
		@NotNull Uf uf,
		String complemento,
		String numero
		) {
}
