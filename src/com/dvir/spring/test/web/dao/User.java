package com.dvir.spring.test.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.dvir.spring.test.web.validation.ValidEmail;

public class User {

	@NotBlank(message = "Username can't be blank")
	@Size(min = 8, max = 20 )
	@Pattern(regexp = "^\\w{8,}$", message = "Username can only consist of numbers and letters and _ chars")
	private String username;

	@NotBlank(message = "password can't be blank")
	@Pattern(regexp = "^\\S+$", message = "cant contain spaces")
	@Size(min = 8, max = 20, message = "password must be between 8 to 20 charecters")
	private String password;

	@ValidEmail(message = "Email not valid")
	private String email;

	private boolean enabled = false;

	private String authority;

	public User() {

	}

	public String getUsername() {
		return username;
	}

	public User(String username, String password, String email, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled + ", authority=" + authority + "]";
	}

}
