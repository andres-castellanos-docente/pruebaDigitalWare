package co.prueba.digitalware.springboot.security.jwt;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		//logger.error("Unauthorized error: {}", authException.getMessage());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		Map<String, Object> data = new HashMap<>();
		data.put("timestamp", LocalDateTime.now().toString());
		data.put("error", "Inautorizado/Unauthorized");
		data.put("status", 401);
		if (authException instanceof BadCredentialsException) {
			data.put("responseDescription", "Usuario y/o Contraseña Incorrectos");
			data.put("responseCode", -1);
		}
		else if (authException instanceof InsufficientAuthenticationException) {
			final String expired = (String) request.getAttribute("expired");
			final String invalid = (String) request.getAttribute("invalid");
			if (expired!=null){
				data.put("responseDescription", "Token Expirado");
				data.put("responseCode", -3);
			} else if (invalid!=null){
				data.put("responseDescription", "Token Inválido");
				data.put("responseCode", -4);
			}
			else{
				data.put("responseDescription", "El servicio Requiere Autenticación por Token");
				data.put("responseCode", -5);
			}
		}
		else if (authException instanceof DisabledException) {
			data.put("responseDescription", "Usuario Inactivo");
			data.put("responseCode", -2);
		}
		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, data);
		out.flush();
	}

}
