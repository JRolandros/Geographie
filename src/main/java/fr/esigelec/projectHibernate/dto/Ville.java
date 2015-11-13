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
		private int id_pays;
		private int nb_habitant;
		private String nom;
		
		
		/**
		 * @param id
		 * @param id_pays
		 * @param nb_habitant
		 * @param nom
		 */
		public Ville(int id, int id_pays, int nb_habitant, String nom) {
			this.id = id;
			this.id_pays = id_pays;
			this.nb_habitant = nb_habitant;
			this.nom = nom;
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
		public int getId_pays() {
			return id_pays;
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
		public void setId_pays(int id_pays) {
			this.id_pays = id_pays;
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
