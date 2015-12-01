/**
 * 
 */
package fr.esigelec.projectHibernate.dao.hibernate;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import fr.esigelec.projectHibernate.dao.IPAysDAO;
import fr.esigelec.projectHibernate.dao.IVilleDAO;
import fr.esigelec.projectHibernate.dto.Pays;
import fr.esigelec.projectHibernate.dto.Ville;

/**
 * @author Rolland
 *
 */
public class PaysDAOImpl implements IPAysDAO {

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IPAysDAO#ajouter(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void ajouter(Pays p) {
		Session session=null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			//session.close();
		
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
        //session.flush();
        session.close();
    }

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IPAysDAO#getPays(int)
	 */
	public Pays getPays(int id) {
		Pays reponse=null;
		try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				reponse=session.get(Pays.class,id);
				session.getTransaction().commit();
				session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reponse;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IPAysDAO#getPays()
	 */
	public List<Pays> getPays() {
		List<Pays> reponse=null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query q=session.createQuery("from Pays"); //requete HQL
			//q.setResultTransformer( Transformers.aliasToBean(Pays.class));
			reponse= (List<Pays>)q.list();
			/*
			for (Pays pays : reponse) {
				session.persist(pays);
				List<Ville> list=(List<Ville>)session.createQuery("from ville ").list();
				pays.setListVille(list);
			}*/
			session.getTransaction().commit();
			session.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reponse;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IPAysDAO#getPays(java.lang.String)
	 */
	public Pays getPays(String nomPays) {
		Pays retour=null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String hql = "from Pays where nom=:nomPays";
			Query query = session.createQuery(hql);
			query.setString("nomPays",nomPays).setMaxResults(1);
			retour= (Pays)query;//.uniqueResult();
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retour;

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IPAysDAO#update(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void update(Pays p) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IPAysDAO#delete(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void delete(Pays p) {
		try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(p);
				session.getTransaction().commit();
				session.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.jdbc.IPAysDAO#refresh(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void refresh(Pays p) {
		p=getPays(p.getId());
	}

}
