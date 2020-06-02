package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Comida;


public interface ComidaDAO extends GenericDAO<Comida, Integer> {

	List<Comida> findByNombre(String string);
	
	
}
