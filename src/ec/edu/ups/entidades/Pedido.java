package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;







/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity

public class Pedido implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private java.util.Calendar fecha;
	private String cliente;
	private double total;
	private String observacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Set<Comida> comida = new HashSet<Comida>();
	
	@OneToOne
	@JoinColumn
	private Targeta targeta;
	
	public Pedido() {
		
		
	}
	public Pedido( Calendar fecha, String cliente) {
		super();
		
		this.fecha=fecha;
		this.cliente=cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public java.util.Calendar getFecha() {
		return fecha;
	}
	public void setFecha(java.util.Calendar fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Set<Comida> getComida() {
		return comida;
	}
	public void setComida(Set<Comida> comida) {
		this.comida = comida;
	}
	public Targeta getTargeta() {
		return targeta;
	}
	public void setTargeta(Targeta targeta) {
		this.targeta = targeta;
	}
	
	public void addProducts(Comida comida) {
		this.comida.add(comida);
	}

	public void removeComida(Comida comida) {
		this.comida.remove(comida);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", total=" + total + ", observacion="
				+ observacion + ", comida=" + comida + ", targeta=" + targeta + "]";
	}
	
	
	
	
	
   
}
