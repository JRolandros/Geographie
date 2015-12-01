package fr.esigelec.projectHibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
//import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Rolland
 *
 */
public class Pays {
	
		private int id;
		private double superficie;
		private String nom;
		private Set<Ville> listVille;
		
		//Constructeurs
		
		public Pays(){
			
		}
		
		

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pays other = (Pays) obj;
			if (id != other.id)
				return false;
			
			if (nom == null) {
				if (other.nom != null)
					return false;
			} else if (!nom.equals(other.nom))
				return false;
			if (Double.doubleToLongBits(superficie) != Double.doubleToLongBits(other.superficie))
				return false;
			return true;
		}

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
		
	
		@Override
		public String toString() {
			return "Pays [id=" + id + ", superficie=" + superficie + ", nom=" + nom + "]";
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
		
		/**
		 * @return the listVille
		 */
		public Set<Ville> getListVille() {
			return listVille;
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


		/**
		 * @param listVille the listVille to set
		 */
		public void setListVille(Set<Ville> listVille) {
			this.listVille = (Set<Ville>)listVille;
		}
		
}
