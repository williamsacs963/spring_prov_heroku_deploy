package mx.uttt.edu.finalev.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import mx.uttt.edu.finalev.app.validation.EmailRegex;
//import mx.uttt.edu.finalev.app.validation.PasswordRegex;
import mx.uttt.edu.finalev.app.validation.UsuarioRegex;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 5010756054880640873L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native",strategy = "native")
	private Long id;
	@Column
	@NotEmpty
	@UsuarioRegex
	private String username;
	@Column
	@NotEmpty
	@EmailRegex
	private String email;
	@Column
	@NotEmpty
	//@PasswordRegex
	private String password;
	
	@Transient
	@NotEmpty
	private String confirmPassword;
	
	public Usuario() {}

	public Usuario(Long id, @NotEmpty String username, @NotEmpty String email, @NotEmpty String password,
			@NotEmpty String confirmPassword) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
}
