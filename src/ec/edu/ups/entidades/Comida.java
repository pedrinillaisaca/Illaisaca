package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;



/**
 * Entity implementation class for Entity: Comida
 *
 */
@Entity

public class Comida implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;		
	private String nombre;
	private double precio;	
	@ManyToOne
	@JoinColumn
	private Pedido pedido;

	public Comida( String nombre, double precio, Pedido pedido ) {
		super();		//
		this.nombre=nombre;
		this.precio=precio;
		this.pedido=pedido;
	}
	public Comida() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "Comida [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", pedido=" + pedido + "]";
	}
   
	
	
	
	
}
