package ec.edu.ups.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Targeta
 *
 */
@Entity

public class Targeta implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String numero;
	private String nombre;
	@Temporal(TemporalType.DATE)
	private java.util.Calendar fechaCaducidad;
	private String cvv;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "targeta")
	Set<Pedido> pedidos=new HashSet<Pedido>();

	public Targeta( String numero, String nombre,String cvv,Calendar fechaCaducidad) {
		super();
		this.numero=numero;
		this.nombre=nombre;
		this.fechaCaducidad=fechaCaducidad;
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


	public String getFechaCaducidad() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");		
		return formato.format(fechaCaducidad.getTime());
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
	public Set<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	public void addPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

	public void removePedido(Pedido pedido) {
		this.pedidos.remove(pedido);
	}


	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		return "Targeta [id=" + id + ", numero=" + numero + ", nombre=" + nombre + ", fechaCaducidad=" + formato.format(fechaCaducidad.getTime())
				+ ", cvv=" + cvv + ", pedidos=" + pedidos + "]";
	}

	
}
