package fr.esigelec.projectHibernate.dto;

/**
 * @author Rolland
 *
 */
public class Pays {
	
		private int id;
		private double superficie;
		private String nom;
		
		//Constructeur
		/**
		 * @param id
		 * @param superficie
		 * @param nom
		 */
		public Pays(int id, double superficie, String nom) {
			this.id = id;
			this.superficie = superficie;
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
		 * @return the superficie
		 */
		public double getSuperficie() {
			return superficie;
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
		 * @param superficie the superficie to set
		 */
		public void setSuperficie(double superficie) {
			this.superficie = superficie;
		}
		/**
		 * @param nom the nom to set
		 */
		public void setNom(String nom) {
			this.nom = nom;
		}
		
}
