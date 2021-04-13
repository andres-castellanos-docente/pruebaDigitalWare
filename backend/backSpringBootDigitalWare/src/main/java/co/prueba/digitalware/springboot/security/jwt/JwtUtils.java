package co.prueba.digitalware.springboot.security.jwt;

import java.util.Date;
import co.prueba.digitalware.springboot.servicessegimpl.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${jwtSecret}")
	private String jwtSecret;

	@Value("${jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject(userPrincipal.getUsername())
				.setHeaderParam("organizationId", userPrincipal.getOrganizationId())
				.setId(userPrincipal.getId().toString())
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public Integer getUserIdFromJwtToken(String token) {
		return new Integer(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getId());
	}

	public Long getOrganizationIdFromJwtToken(String token) {
		return new Long(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getHeader().get("organizationId").toString());
	}

	public boolean validateJwtToken(String authToken, HttpServletRequest httpServletRequest) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
		} catch (MalformedJwtException e) {
			httpServletRequest.setAttribute("invalid","true");
		} catch (ExpiredJwtException e) {
			httpServletRequest.setAttribute("expired","true");
		} catch (UnsupportedJwtException e) {
			httpServletRequest.setAttribute("invalid","true");
		} catch (IllegalArgumentException e) {
		}
		return false;
	}

	public String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}
