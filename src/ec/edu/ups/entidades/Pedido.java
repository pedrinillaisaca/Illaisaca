package ec.edu.ups.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
	
	@ManyToOne
	@JoinColumn
	private Targeta targeta;
	
	public Pedido() {	
	super();
	}
	public Pedido( Calendar fecha, String cliente, Targeta targeta) {
		super();		
		this.fecha=fecha;
		this.cliente=cliente;
		this.targeta=targeta;
		
	}
	public int getId() {		
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		
		return formato.format(fecha.getTime());
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
	
	public void addComida(Comida comida) {
		this.comida.add(comida);
	}

	public void removeComida(Comida comida) {
		this.comida.remove(comida);
	}
	
	public void calcularComidas() {
		double s=0;
		for (Comida comida2 : comida) {
			s+=comida2.getPrecio();
		}
		setTotal(s);
	}


	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
		
		return "Pedido [id=" + id + ", fecha=" + formato.format(fecha.getTime()) + ", cliente=" + cliente + ", total=" + total + ", observacion="
				+ observacion + ", comida=" + comida + ", targeta=" + targeta + "]";
	}
	
	
	
	
	
   
}
