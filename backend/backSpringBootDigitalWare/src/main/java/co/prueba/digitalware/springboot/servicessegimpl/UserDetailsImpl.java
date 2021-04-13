package co.prueba.digitalware.springboot.servicessegimpl;

import java.util.Collection;
import java.util.Objects;
import co.prueba.digitalware.springboot.entities.UsuariosrestEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private boolean enabled;

	private Long organizationId;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String username, String email, String password, boolean enabled) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	public static UserDetailsImpl build(UsuariosrestEntity user) {

		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(), 
				user.getEmail(),
				user.getPassword(),
				user.isActivo());
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}


	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}
