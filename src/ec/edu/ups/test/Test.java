package ec.edu.ups.test;

import java.util.GregorianCalendar;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;

import ec.edu.ups.entidades.Comida;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Targeta;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Targeta t=new Targeta();
		t.setFechaCaducidad(new  GregorianCalendar());
		t.setNombre("eoidsfj");
		
		Pedido p=new Pedido();
		p.setCliente("pedro");
		Comida c=new Comida("wefasd",2.34);
		Comida c2=new Comida("wefasd",2.34);
		Comida c3=new Comida("wefasd",2.34);
		
		
		
		p.addProducts(c);
		p.addProducts(c2);
		p.addProducts(c3);
		
		
		p.setTargeta(t);
		
		PedidoDAO pedidoDAO=DAOFactory.getFactory().getPedidoDAO();
		pedidoDAO.create(p);
		
		System.out.println(pedidoDAO.find());
		
	}

}
