/**
 * 
 */
package fr.esigelec.projectHibernate.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import fr.esigelec.projectHibernate.dao.IVilleDAO;
import fr.esigelec.projectHibernate.dto.Ville;

/**
 * @author Rolland
 *
 */
public class VilleDAO implements IVilleDAO {

	PreparedStatement preparedStatement = null;
	
	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IVilleDAO#ajouter(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void ajouter(Ville v) {
		
		String insertTableSQL = "INSERT INTO ville"
				+ "(id_pays, nb_habitant, nom) VALUES"
				+ "(?,?,?)";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, v.getPays().getId());
			preparedStatement.setInt(2, v.getNb_habitant());
			preparedStatement.setString(3, v.getNom());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//finally close the connction
				ConnectionManager.close();
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IVilleDAO#getVille(int)
	 */
	public Ville getVille(int id) {
		Ville v=null;
		PaysDAO pDao=new PaysDAO();
		
		String selectSQL = "SELECT* FROM ville WHERE id = ?";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			// execute insert SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			v=new Ville();
			v.setId(id);
			v.setNb_habitant(rs.getInt("nb_habitant"));
			v.setNom(rs.getString("nom"));
			v.setPays(pDao.getPays(rs.getInt("id_pays")));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//finally close the connection
				ConnectionManager.close();
			}
		}

		return v;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IVilleDAO#getVilles()
	 */
	public List<Ville> getVilles() {
		List<Ville> listV=new LinkedList<Ville>();
		Ville v=null;
		PaysDAO pDao=new PaysDAO();
		
		String selectSQL = "SELECT* FROM ville";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(selectSQL);

			// execute insert SQL stetement	
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
			v=new Ville();
			v.setId(rs.getInt("id"));
			v.setNb_habitant(rs.getInt("nb_habitant"));
			v.setNom(rs.getString("nom"));
			v.setPays(pDao.getPays(rs.getInt("id_pays")));
			listV.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ConnectionManager.close();
			}
		}
		return listV;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IVilleDAO#update(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void update(Ville v) {
		
		String updateTableSQL = "UPDATE ville"
				+ " SET id_pays = ?"
				+ " SET nb_habitant=?"
				+ " SET nom= ?"
				+ " WHERE id = ?";
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(updateTableSQL);
			preparedStatement.setInt(1, v.getPays().getId());
			preparedStatement.setInt(2, v.getNb_habitant());
			preparedStatement.setString(3, v.getNom());
			preparedStatement.setInt(3, v.getId());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ConnectionManager.close();
			}
		}

	}
	

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IVilleDAO#delete(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void delete(Ville v) {
		String deleteSQL = "DELETE ville WHERE id = ?";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(deleteSQL);
			preparedStatement.setInt(1, v.getId());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ConnectionManager.close();
			}
		}
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IVilleDAO#refresh(fr.esigelec.projectHibernate.dto.Ville)
	 */
	public void refresh(Ville v) {
		// TODO Auto-generated method stub

	}
	// this methode is note worth here, just for hibernate implementation
	public void closeHibernateSession(){
		
	}

}
