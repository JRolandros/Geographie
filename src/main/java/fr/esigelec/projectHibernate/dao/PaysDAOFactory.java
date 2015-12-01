/**
 * 
 */
package fr.esigelec.projectHibernate.dao;

import fr.esigelec.projectHibernate.dao.hibernate.PaysDAOImpl;
import fr.esigelec.projectHibernate.dao.jdbc.PaysDAO;

/**
 * @author Rolland
 *
 */
public class PaysDAOFactory {

	public static IPAysDAO getPaysDAO(String DAOImplementation){
		switch(DAOImplementation.toUpperCase()){
		case "PAYSDAOIMPL":
			return new PaysDAOImpl();
		case "PAYSDAO":
			return new PaysDAO();
		default:
				return null;
		}
	}
}
