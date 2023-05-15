package med.voll.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import med.voll.api.domain.usuario.Usuario;

@Service
public class TokenService {
		
	public String gerarToken(Usuario usuario) {
		try {
		    Algorithm algoritmo = Algorithm.HMAC256("123456"); //algoritmo para realizar a assinatura digital do jwt
		    return JWT.create()
		        .withIssuer("API Voll.med")
		        .withSubject(usuario.getLogin())
		        .withClaim("id", usuario.getId())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritmo);
		} catch (JWTCreationException exception){
			throw new RuntimeException("Erro ao gerar o token jwt", exception); //evitar que quem chame a classe fique lancando exception
		}
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
}
