package mx.uttt.edu.finalev.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Proveedor implements Serializable {

	private static final long serialVersionUID = 7409862256072645905L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native",strategy = "native")
	private Long id;
	@Column
	@NotEmpty
	private String nombreCompania;
	@Column
	@NotEmpty
	private String nombreContacto;
	@Column
	@NotEmpty
	private String tituloContacto;
	@Column
	@NotEmpty
	private String direccion;
	@Column
	@NotEmpty
	private String ciudad;
	@Column
	@NotEmpty
	private String telefono;
	@Column
	@NotEmpty
	private String fax;
	@Column
	@NotEmpty
	private String sitioWeb;
	@Column
	@NotEmpty
	private String facebook;
	@Column
	@NotEmpty
	private String twitter;
	@Column
	@NotEmpty
	private String correoElectronico;
	
	public Proveedor() {}

	public Proveedor(Long id, @NotEmpty String nombreCompania, @NotEmpty String nombreContacto,
			@NotEmpty String tituloContacto, @NotEmpty String direccion, @NotEmpty String ciudad,
			@NotEmpty String telefono, @NotEmpty String fax, @NotEmpty String sitioWeb, @NotEmpty String facebook,
			@NotEmpty String twitter, @NotEmpty String correoElectronico) {
		this.id = id;
		this.nombreCompania = nombreCompania;
		this.nombreContacto = nombreContacto;
		this.tituloContacto = tituloContacto;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.fax = fax;
		this.sitioWeb = sitioWeb;
		this.facebook = facebook;
		this.twitter = twitter;
		this.correoElectronico = correoElectronico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTituloContacto() {
		return tituloContacto;
	}

	public void setTituloContacto(String tituloContacto) {
		this.tituloContacto = tituloContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
}
