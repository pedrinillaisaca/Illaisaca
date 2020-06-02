package ec.edu.ups.jpa;



import javax.persistence.Query;

import ec.edu.ups.dao.TargetaDAO;

import ec.edu.ups.entidades.Targeta;

public class JPATargetaDAO extends JPAGenericDAO<Targeta, Integer> implements TargetaDAO {

	public JPATargetaDAO() {
		super(Targeta.class);
	}

	@Override
	public Targeta findByNumero(int numTar) {
				
		String jpql="SELECT t FROM Targeta t WHERE t.numero="+numTar;
		Query query=em.createQuery(jpql);
		Targeta t=(Targeta) query.getSingleResult();
		
//		String jpql2="SELECT t FROM Telefono t WHERE t.usuario.id="+u.getId();
//		List<?> tele= em.createQuery(jpql2).getResultList();
//		Set<Telefono> t=new HashSet<Telefono>();
//		for (int i = 0; i < tele.size(); i++) {			
//			t.add((Telefono) tele.get(i));
//		}
//			u.setTelefonos(t);
		return t;
	}
}
