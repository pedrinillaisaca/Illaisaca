package ec.edu.ups.dao;


import java.util.List;

import ec.edu.ups.entidades.Pedido;

public interface PedidoDAO extends GenericDAO<Pedido, Integer> {

	List<Pedido> findByComida(String string);

	List<Pedido> findByNumTar(String string);

}
