import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.esigelec.projectHibernate.dao.hibernate.PaysDAOImpl;
import fr.esigelec.projectHibernate.dao.hibernate.VilleDAOImpl;
import fr.esigelec.projectHibernate.dao.jdbc.PaysDAO;
import fr.esigelec.projectHibernate.dao.jdbc.VilleDAO;

@RunWith(Suite.class)
@SuiteClasses({
	VilleDAO.class,
	VilleDAOImpl.class,
	PaysDAO.class,
	PaysDAOImpl.class
})
public class DAOTests {

}
