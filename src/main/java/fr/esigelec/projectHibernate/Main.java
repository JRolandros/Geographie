/**
 * 
 */
package fr.esigelec.projectHibernate;

import fr.esigelec.projectHibernate.dao.hibernate.PaysDAOImpl;
import fr.esigelec.projectHibernate.dao.hibernate.VilleDAOImpl;
import fr.esigelec.projectHibernate.dao.jdbc.PaysDAO;
import fr.esigelec.projectHibernate.dao.jdbc.VilleDAO;
import fr.esigelec.projectHibernate.dao.IPAysDAO;
import fr.esigelec.projectHibernate.dao.IVilleDAO;
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
		//Instances d'objets DAO
		IVilleDAO vDao;
		IPAysDAO pDao;
		
		//vDao=new VilleDAOImpl();
		//pDao=new PaysDAOImpl();
		
		vDao=new VilleDAO();
		pDao=new PaysDAO();
		//Instances d'objet beans
		Pays p=new Pays(1,474000,"France");
		
		
		//System.out.println(p.toString());
		
		//Test d'ajout
		//pDao.ajouter(p);
		
		//p=pDao.getPays(4);
		Ville v;//=new Ville(0,p,1452,"Paris");
		//vDao.ajouter(v);
		v=vDao.getVille(9);
		System.out.println("Avant: "+ v.toString());
		//v.setNom("Kribi");
		//v.setNb_habitant(100000);
		//vDao.update(v);
		//System.out.println( v.toString());
		
		//pDao.delete(p);
		
		
		//vDao.delete(v);
		

	}

}
