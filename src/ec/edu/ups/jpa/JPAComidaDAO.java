package ec.edu.ups.jpa;

import ec.edu.ups.dao.ComidaDAO;
import ec.edu.ups.entidades.Comida;

public class JPAComidaDAO extends JPAGenericDAO<Comida, Integer> implements ComidaDAO {

	public JPAComidaDAO() {
		super(Comida.class);
		// TODO Auto-generated constructor stub
	}

}
