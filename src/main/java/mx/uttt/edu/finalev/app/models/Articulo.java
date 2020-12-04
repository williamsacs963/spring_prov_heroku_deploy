package mx.uttt.edu.finalev.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Articulo implements Serializable{

	private static final long serialVersionUID = -145885514266247276L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native",strategy = "native")
	private Long id;
	@NotEmpty
	private String nombre;
	@NotNull
	private double cantidadPorUnidad;
	@NotNull
	private double unidadesEnStock;
	@NotNull
	private double unidadesOrdenadas;
	@NotNull
	private double nivelOrdenamiento;
	@NotNull
	private boolean descotinuado;
	@NotNull
	private double margenUtilidad;
	@NotNull
	private double precioMayoreo;
	@NotNull
	private double numSku;
	@NotEmpty
	private String unidadMedida;
	@NotNull
	private Long id_proveedor;
		
	public Articulo() {}

	public Articulo(Long id, @NotEmpty String nombre, @NotNull double cantidadPorUnidad,
			@NotNull double unidadesEnStock, @NotNull double unidadesOrdenadas, @NotNull double nivelOrdenamiento,
			@NotNull boolean descotinuado, @NotNull double margenUtilidad, @NotNull double precioMayoreo,
			@NotNull double numSku, @NotEmpty String unidadMedida, @NotNull Long id_proveedor) {
		//super();
		this.id = id;
		this.nombre = nombre;
		this.cantidadPorUnidad = cantidadPorUnidad;
		this.unidadesEnStock = unidadesEnStock;
		this.unidadesOrdenadas = unidadesOrdenadas;
		this.nivelOrdenamiento = nivelOrdenamiento;
		this.descotinuado = descotinuado;
		this.margenUtilidad = margenUtilidad;
		this.precioMayoreo = precioMayoreo;
		this.numSku = numSku;
		this.unidadMedida = unidadMedida;
		this.id_proveedor = id_proveedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidadPorUnidad() {
		return cantidadPorUnidad;
	}

	public void setCantidadPorUnidad(double cantidadPorUnidad) {
		this.cantidadPorUnidad = cantidadPorUnidad;
	}

	public double getUnidadesEnStock() {
		return unidadesEnStock;
	}

	public void setUnidadesEnStock(double unidadesEnStock) {
		this.unidadesEnStock = unidadesEnStock;
	}

	public double getUnidadesOrdenadas() {
		return unidadesOrdenadas;
	}

	public void setUnidadesOrdenadas(double unidadesOrdenadas) {
		this.unidadesOrdenadas = unidadesOrdenadas;
	}

	public double getNivelOrdenamiento() {
		return nivelOrdenamiento;
	}

	public void setNivelOrdenamiento(double nivelOrdenamiento) {
		this.nivelOrdenamiento = nivelOrdenamiento;
	}

	public boolean isDescotinuado() {
		return descotinuado;
	}

	public void setDescotinuado(boolean descotinuado) {
		this.descotinuado = descotinuado;
	}

	public double getMargenUtilidad() {
		return margenUtilidad;
	}

	public void setMargenUtilidad(double margenUtilidad) {
		this.margenUtilidad = margenUtilidad;
	}

	public double getPrecioMayoreo() {
		return precioMayoreo;
	}

	public void setPrecioMayoreo(double precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}

	public double getNumSku() {
		return numSku;
	}

	public void setNumSku(double numSku) {
		this.numSku = numSku;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Long getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", nombre=" + nombre + ", cantidadPorUnidad=" + cantidadPorUnidad
				+ ", unidadesEnStock=" + unidadesEnStock + ", unidadesOrdenadas=" + unidadesOrdenadas
				+ ", nivelOrdenamiento=" + nivelOrdenamiento + ", descotinuado=" + descotinuado + ", margenUtilidad="
				+ margenUtilidad + ", precioMayoreo=" + precioMayoreo + ", numSku=" + numSku + ", unidadMedida="
				+ unidadMedida + ", id_proveedor=" + id_proveedor + "]";
	}
	
	
}
