import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import fr.esigelec.projectHibernate.dao.IPAysDAO;
import fr.esigelec.projectHibernate.dao.IVilleDAO;
import fr.esigelec.projectHibernate.dao.PaysDAOFactory;
import fr.esigelec.projectHibernate.dto.Pays;

public class TestPaysDAO {
	
	IPAysDAO paysDao;
	IVilleDAO villeDao;

	@Test
	public void testAjouter() {
		
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOImpl");
		Pays p=new Pays(0,148562,"Libye");
		paysDao.ajouter(p);
		assertNotEquals(0, p.getId());
	}

	@Ignore
	public void testGetPaysInt() {
		
			paysDao=PaysDAOFactory.getPaysDAO("PaysDAOJDBC");
			Pays p=new Pays(17,148569.0,"USA");
			//paysDao.ajouter(p);
			Pays newP=paysDao.getPays(p.getId());
			System.out.println(newP);
			assertEquals(newP, p);
	}

	@Ignore
	public void testGetPays() {
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOJDBC");
		Pays p=new Pays(17,148569,"USA");
		List<Pays> l=(List<Pays>) paysDao.getPays();
		assertTrue(l.size()>=2);
		assertTrue(l.contains(p));
	}

	@Ignore
	public void testGetPaysString() {
		
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
