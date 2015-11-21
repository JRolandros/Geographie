/**
 * 
 */
package fr.esigelec.projectHibernate.dao;

import java.util.List;

import fr.esigelec.projectHibernate.dto.Ville;

/**
 * @author Rolland
 *
 */
public interface IVilleDAO {
	
	public void ajouter(Ville v);
	public Ville getVille(int id);
	public List<Ville> getVilles();
	public void update(Ville v);
	public void delete(Ville v);
	public void refresh(Ville v);

}
