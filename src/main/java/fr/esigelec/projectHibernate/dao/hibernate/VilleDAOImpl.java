/**
 * 
 */
package fr.esigelec.projectHibernate.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esigelec.projectHibernate.dao.IVilleDAO;
import fr.esigelec.projectHibernate.dto.Ville;

/**
 * @author Rolland
 *
 */
public class VilleDAOImpl implements IVilleDAO {

	Session session=null;
	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IVilleDAO#ajouter(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void ajouter(Ville v) {
		try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.save(v);
				session.getTransaction().commit();
				session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IVilleDAO#getVille(int)
	 */
	public Ville getVille(int id) {
		Ville reponse=null;
		try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				reponse=(Ville)session.get(Ville.class,id);
				session.getTransaction().commit();
				
				//session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reponse;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IVilleDAO#getVilles()
	 */
	public List<Ville> getVilles() {
		List<Ville> reponse=null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q=session.createQuery("from Ville"); //requete HQL
			reponse=q.list();
			session.getTransaction().commit();
			//session.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reponse;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IVilleDAO#update(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void update(Ville v) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(v);			
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IVilleDAO#delete(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void delete(Ville v) {
		try {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(v);
				session.getTransaction().commit();
				session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IVilleDAO#refresh(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void refresh(Ville v) {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(v);
		session.refresh(v);
		session.getTransaction().commit();
		session.close();
		//v=getVille(v.getId());
	}
	
	public void closeHibernateSession(){
		session.close();
	}

}
