package ec.edu.ups.jpa;

import ec.edu.ups.entidades.Targeta;

public class JPATargetaDAO extends JPAGenericDAO<Targeta, Integer> {

	public JPATargetaDAO() {
		super(Targeta.class);
	}
}
