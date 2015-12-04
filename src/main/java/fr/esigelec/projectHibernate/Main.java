/**
 * 
 */
package fr.esigelec.projectHibernate;

import fr.esigelec.projectHibernate.dao.hibernate.PaysDAOImpl;
import fr.esigelec.projectHibernate.dao.hibernate.VilleDAOImpl;
import fr.esigelec.projectHibernate.dao.jdbc.PaysDAO;
import fr.esigelec.projectHibernate.dao.jdbc.VilleDAO;

import java.util.List;

import fr.esigelec.projectHibernate.dao.IPAysDAO;
import fr.esigelec.projectHibernate.dao.IVilleDAO;
import fr.esigelec.projectHibernate.dao.PaysDAOFactory;
import fr.esigelec.projectHibernate.dao.VilleDAOFactory;
import fr.esigelec.projectHibernate.dto.Pays;
import fr.esigelec.projectHibernate.dto.Ville;

/**
 * @author Rolland
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IPAysDAO pDAO;
		IVilleDAO vDAO;
		Pays p=new Pays(24,148569,"USA");
		Ville v=new Ville(0, p, 152360, "Aklga");
		
		vDAO=VilleDAOFactory.getVilleDAO("VILLEDAOHibernate");
		
		//vDAO.ajouter(v);
		//List<Ville> listVille=vDAO.getVilles();
		//System.out.println(listVille);
		vDAO.closeHibernateSession();

	}

}
