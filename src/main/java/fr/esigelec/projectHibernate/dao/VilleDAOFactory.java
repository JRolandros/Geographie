/**
 * 
 */
package fr.esigelec.projectHibernate.dao;

import fr.esigelec.projectHibernate.dao.hibernate.VilleDAOImpl;
import fr.esigelec.projectHibernate.dao.jdbc.VilleDAO;

/**
 * @author Rolland
 *
 */
public class VilleDAOFactory {
	
	public static IVilleDAO getVilleDAO(String DAOImplementation){
		switch(DAOImplementation.toUpperCase()){
		case "VILLEDAOHIBERNATE":
			return new VilleDAOImpl();
		case "VILLEDAOJDBC":
			return new VilleDAO();
		default:
				return null;
		}
	}
}
