package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Targeta
 *
 */
@Entity

public class Targeta implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String numero;
	private String nombre;
	@Temporal(TemporalType.DATE)
	private java.util.Calendar fechaCaducidad;
	private String cvv;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "targeta")
	private Pedido pedido;

	public Targeta( String numero, String nombre,String cvv) {
		
		this.nombre=numero;
		this.nombre=nombre;
		this.cvv=cvv;
	}

	
	public Targeta() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public java.util.Calendar getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(java.util.Calendar fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	@Override
	public String toString() {
		return "Targeta [id=" + id + ", numero=" + numero + ", nombre=" + nombre + ", fechaCaducidad=" + fechaCaducidad
				+ ", cvv=" + cvv + ", pedido=" + pedido + "]";
	}
   
	
	
}
