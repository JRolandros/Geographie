import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.esigelec.projectHibernate.dao.IPAysDAO;
import fr.esigelec.projectHibernate.dao.IVilleDAO;
import fr.esigelec.projectHibernate.dao.VilleDAOFactory;
import fr.esigelec.projectHibernate.dto.Pays;
import fr.esigelec.projectHibernate.dto.Ville;

public class TestVilleDAO {

	IPAysDAO pDAO;
	IVilleDAO vDAO;
	@Test
	public void testAjouter() {
		Pays p=new Pays(24,148569,"USA");
		Ville v=new Ville(0, p, 152360, "PANDA");
		vDAO=VilleDAOFactory.getVilleDAO("VILLEDAOJDBC");
		vDAO.ajouter(v);
		System.out.println(v);
	}

	@Test
	public void testGetVille() {
	
	}

	@Test
	public void testGetVilles() {
		vDAO=VilleDAOFactory.getVilleDAO("VILLEDAOJDBC");
		List<Ville> listVille=vDAO.getVilles();
		System.out.println(listVille);
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testRefresh() {
		
	}

}
