/**
 * 
 */
package fr.esigelec.projectHibernate.dao;

import java.util.List;

import fr.esigelec.projectHibernate.dto.Pays;

/**
 * @author Rolland
 *
 */
public interface IPAysDAO {
	
	public void ajouter(Pays p);
	public Pays getPays(int id);
	public List<Pays> getPays();
	public Pays getPays(String nomPays);
	public void update(Pays p);
	public void delete(Pays p);
	public void refresh(Pays p);

}
