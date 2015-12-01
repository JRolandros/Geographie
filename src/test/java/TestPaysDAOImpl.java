import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import fr.esigelec.projectHibernate.dao.*;
import fr.esigelec.projectHibernate.dto.*;

public class TestPaysDAOImpl {
	
	IPAysDAO paysDao;
	IVilleDAO villeDao;

	@Ignore
	public void testAjouter() {
		
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOImpl");
		Pays p=new Pays(0,148569632,"USA1");
		paysDao.ajouter(p);
		assertNotEquals(0, p.getId());
	}
	
	@Ignore
	public void testGetPaysInt() {
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOImpl");
		Pays p=new Pays(13,148569632,"USA");
		//paysDao.ajouter(p);
		Pays newP=paysDao.getPays(p.getId());
		assertEquals(newP, p);
	}

	@Ignore
	public void testGetPays() {
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOImpl");
		Pays p=new Pays(15,148569,"USA");
		List<Pays> l=(List<Pays>) paysDao.getPays();
		assertTrue(l.size()>=2);
		assertTrue(l.contains(p));
	}

	@Ignore
	public void testGetPaysString() {
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOImpl");
		Pays p=new Pays(14,148569632,"Cameroun");
		//paysDao.ajouter(p);
		Pays newP=paysDao.getPays("Cameroun");
		assertEquals(newP, p);
	}

	@Ignore
	public void testUpdate() {
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOImpl");
		Pays p=paysDao.getPays("Cameroun");
		String nameP=p.getNom();
		p.setNom("Canada");
		paysDao.update(p);
		assertTrue(!nameP.equals(p.getNom()));
	}

	@Ignore
	public void testDelete() {
		paysDao=PaysDAOFactory.getPaysDAO("PaysDAOImpl");
		Pays p=paysDao.getPays("Canada");
		//paysDao.delete(p);
		assertNull(paysDao.getPays("Canada"));
	}

	@Test
	public void testRefresh() {
		
	}

}
