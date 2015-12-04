import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import fr.esigelec.projectHibernate.dao.IPAysDAO;
import fr.esigelec.projectHibernate.dao.IVilleDAO;
import fr.esigelec.projectHibernate.dao.VilleDAOFactory;
import fr.esigelec.projectHibernate.dto.Pays;
import fr.esigelec.projectHibernate.dto.Ville;

public class TestVilleDAOImpl {
	IPAysDAO pDAO;
	IVilleDAO vDAO;
	@Ignore
	public void testAjouter() {
		Pays p=new Pays(24,148569,"USA");
		Ville v=new Ville(0, p, 152360, "Aklga");
		vDAO=VilleDAOFactory.getVilleDAO("VILLEDAOHibernate");
		vDAO.ajouter(v);
	}

	@Ignore
	public void testGetVille() {
		
	}

	@Test
	public void testGetVilles() {
		//vDAO=VilleDAOFactory.getVilleDAO("VILLEDAOJDBC");
				vDAO=VilleDAOFactory.getVilleDAO("VILLEDAOHibernate");
				List<Ville> listVille=vDAO.getVilles();
				System.out.println(listVille);
				vDAO.closeHibernateSession();
	}

	@Ignore
	public void testUpdate() {
		
	}

	@Ignore
	public void testDelete() {
		
	}

	@Ignore
	public void testRefresh() {
		
	}

}
