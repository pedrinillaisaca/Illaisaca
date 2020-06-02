package ec.edu.ups.test;

import java.awt.List;
import java.util.GregorianCalendar;

import ec.edu.ups.dao.ComidaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.dao.TargetaDAO;
import ec.edu.ups.entidades.Comida;
import ec.edu.ups.entidades.Pedido;
import ec.edu.ups.entidades.Targeta;
import sun.font.CreatedFontTracker;

public class Test {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		TargetaDAO targetaDAO = DAOFactory.getFactory().getTargetaDAO();

		targetaDAO.create(new Targeta("234987", "visa", "wqwe32", new GregorianCalendar()));
		targetaDAO.create(new Targeta("634563","diners","1234rq",new GregorianCalendar()));
		targetaDAO.create(new Targeta("346334","master","2f34q4",new GregorianCalendar()));


		
		PedidoDAO pedidoDAO=DAOFactory.getFactory().getPedidoDAO();
		
		
		System.out.println(pedidoDAO.findByNumTar("234987"));
	
		System.out.println(pedidoDAO.findByComida("bolon"));
		
	}

}
