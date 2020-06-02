package ec.edu.ups.dao;

import ec.edu.ups.entidades.Targeta;

public interface TargetaDAO extends GenericDAO<Targeta, Integer>{

	Targeta findByNumero(int parseInt);

}
