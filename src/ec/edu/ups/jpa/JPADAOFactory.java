package ec.edu.ups.jpa;


import ec.edu.ups.dao.ComidaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.dao.TargetaDAO;

public class JPADAOFactory extends DAOFactory{

	

	@Override
	public PedidoDAO getPedidoDAO() {
		// TODO Auto-generated method stub
		return  new JPAPedidoDAO();
	}

	@Override
	public ComidaDAO getComidaDAO() {
		// TODO Auto-generated method stub
		return new JPAComidaDAO();
	}

	@Override
	public TargetaDAO getTargetaDAO() {
		// TODO Auto-generated method stub
		return new JPATargetaDAO();
	}

	
}
