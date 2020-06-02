package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.edu.ups.dao.GenericDAO;

public class JPAGenericDAO<T,ID> implements GenericDAO<T, ID>{
	
	
	private Class<T> persistentClass;
    protected EntityManager em;

    public JPAGenericDAO(Class<T> persistentClass) {
	this.persistentClass = persistentClass;
	this.em = Persistence.createEntityManagerFactory("jpa").createEntityManager();
    }

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
		    em.persist(entity);
		    em.getTransaction().commit();
		    System.out.println("CREANDO USUARIO");
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:create " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
		
		
	}

	@Override
	public T read(ID id) {		
		return em.find(persistentClass, id);
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		try {
		    em.merge(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}

	}

	@Override
	public void delete(T entity) {
		em.getTransaction().begin();
		try {
		    em.remove(entity);
		    em.getTransaction().commit();
		} catch (Exception e) {
		    System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
		    if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteByID(ID id) {
		T entity = this.read(id);//PRIMERO DEBE SER BUSCADA PARA LUEGO SER ELIMINADA
		if (entity != null)
		    this.delete(entity);	   
	}

	@Override
	public List<T> find() {
		// Se crea un criterio de consulta
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    	CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);
    	// Se establece la clausula FROM
    	Root<T> root = criteriaQuery.from(this.persistentClass);
    	// Se establece la clausula SELECT
    	criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))
    				    // // Se configuran los predicados,
    				    // combinados por AND
    	Predicate predicate = criteriaBuilder.conjunction();
    	
    	// Se establece el WHERE
    	criteriaQuery.where(predicate);
    	// Se establece el orden
    	
    	TypedQuery<T> tq = em.createQuery(criteriaQuery);
	    
	    return tq.getResultList();    
	}

	@Override
	public List<T> find(String[] attributes, String[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> find(String[] attributes, String[] values, String order, int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
