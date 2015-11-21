/**
 * 
 */
package fr.esigelec.projectHibernate.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import fr.esigelec.projectHibernate.dao.IPAysDAO;
import fr.esigelec.projectHibernate.dto.Pays;
import fr.esigelec.projectHibernate.dto.Ville;

/**
 * @author Rolland
 *
 */
public class PaysDAO implements IPAysDAO {
	PreparedStatement preparedStatement = null;
	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IPAysDAO#ajouter(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void ajouter(Pays p) {
		
		String insertTableSQL = "INSERT INTO pays"
				+ "(nom,superficie) VALUES"
				+ "(?,?)";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(insertTableSQL);
			preparedStatement.setString(1,p.getNom());
			preparedStatement.setDouble(2, p.getSuperficie());

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
				ConnectionManager.close();
			}
		}

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IPAysDAO#getPays(int)
	 */
	public Pays getPays(int id) {

		Pays p=null;
		String selectSQL = "SELECT* FROM pays WHERE id = ?";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			// execute insert SQL stetement			
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			p=new Pays();
			p.setId(id);
			p.setNom(rs.getString("nom"));
			p.setSuperficie(rs.getDouble("superficie"));
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
		return p;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IPAysDAO#getPays()
	 */
	public List<Pays> getPays() {
		List<Pays> listP=new LinkedList<Pays>();
		Pays p=null;
		String selectSQL = "SELECT* FROM pays";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(selectSQL);

			// execute insert SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
			p=new Pays();
			p.setId(rs.getInt("id"));
			p.setNom(rs.getString("nom"));
			p.setSuperficie(rs.getDouble("superficie"));
			listP.add(p);
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
		return listP;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IPAysDAO#getPays(java.lang.String)
	 */
	public Pays getPays(String nomPays) {
		Pays p=null;
		String selectSQL = "SELECT* FROM pays WHERE nom = ?";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(selectSQL);
			preparedStatement.setString(1, nomPays);

			// execute insert SQL stetement		
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			p=new Pays();
			p.setId(rs.getInt("id"));
			p.setNom(rs.getString("nom"));
			p.setSuperficie(rs.getDouble("superficie"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
		return p;
	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IPAysDAO#update(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void update(Pays p) {
		String insertTableSQL = "UPDATE pays"
				+ " SET nom = ?"
				+ " SET superficie=?"
				+ " WHERE id = ?";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(insertTableSQL);
			preparedStatement.setString(1,p.getNom());
			preparedStatement.setDouble(2, p.getSuperficie());
			preparedStatement.setInt(3,p.getId());

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
				ConnectionManager.close();
			}
		}

	}

	/* (non-Javadoc)
	 * @see fr.esigelec.projectHibernate.dao.IPAysDAO#delete(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void delete(Pays p) {
		
		String deleteSQL = "DELETE pays WHERE id = ?";
		
		try {
			preparedStatement = ConnectionManager.getConnection().prepareStatement(deleteSQL);
			preparedStatement.setInt(1, p.getId());

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
	 * @see fr.esigelec.projectHibernate.dao.IPAysDAO#refresh(fr.esigelec.projectHibernate.dto.Pays)
	 */
	public void refresh(Pays p) {
		// TODO Auto-generated method stub

	}

}
