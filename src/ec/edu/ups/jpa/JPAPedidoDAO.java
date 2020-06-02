package ec.edu.ups.jpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.entidades.Comida;
import ec.edu.ups.entidades.Pedido;

public class JPAPedidoDAO extends JPAGenericDAO<Pedido, Integer> implements PedidoDAO{

	public JPAPedidoDAO() {
		super(Pedido.class);
	}

	
	@Override
	public List<Pedido> findByComida(String comida) {
		String jpql2="SELECT c FROM Comida c WHERE c.nombre='"+comida+"'";
		List<?> comidas= em.createQuery(jpql2).getResultList();
		Set<Pedido> p=new HashSet<Pedido>();
		
		for (int i = 0; i < comidas.size(); i++) {	
			Comida c=(Comida) comidas.get(i);
			p.add(c.getPedido());
		}
		List<Pedido> list = new ArrayList<Pedido>(p);
		return list;
	}

	
	@Override
	public List<Pedido> findByNumTar(String numTar) {
		String jpql2="SELECT p FROM Pedido p WHERE p.targeta.numero="+numTar;
		List<?> pedidos= em.createQuery(jpql2).getResultList();
		Set<Pedido> p=new HashSet<Pedido>();
		
		for (int i = 0; i < pedidos.size(); i++) {
			
			p.add((Pedido) pedidos.get(i));
		}
		List<Pedido> list = new ArrayList<Pedido>(p);
		return list;
	}
	
	

}
