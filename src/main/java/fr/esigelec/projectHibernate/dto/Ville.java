/**
 * 
 */
package fr.esigelec.projectHibernate.dto;

/**
 * @author Rolland
 *
 */
public class Ville {
	
		private int id;
		private Pays pays;
		private int nb_habitant;
		private String nom;
		
		//Constructeurs
		
		public Ville(){
			
		}
		
		/**
		 * @param id
		 * @param id_pays
		 * @param nb_habitant
		 * @param nom
		 */
		public Ville(int id, Pays pays, int nb_habitant, String nom) {
			this.id = id;
			this.pays = pays;
			this.nb_habitant = nb_habitant;
			this.nom = nom;
		}
		
		@Override
		public String toString() {
			return "Ville [id=" + id + ", pays=" + pays + ", nb_habitant=" + nb_habitant + ", nom=" + nom + "]\n";
		}


		//Getters
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @return the id_pays
		 */
		public Pays getPays() {
			return pays;
		}
		/**
		 * @return the nb_habitant
		 */
		public int getNb_habitant() {
			return nb_habitant;
		}
		/**
		 * @return the nom
		 */
		public String getNom() {
			return nom;
		}
		
		//Setters
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @param id_pays the id_pays to set
		 */
		public void setPays(Pays pays) {
			this.pays = pays;
		}
		/**
		 * @param nb_habitant the nb_habitant to set
		 */
		public void setNb_habitant(int nb_habitant) {
			this.nb_habitant = nb_habitant;
		}
		
		/**
		 * @param nom the nom to set
		 */
		public void setNom(String nom) {
			this.nom = nom;
		}
}
