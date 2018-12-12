package beans;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Koordinate;

@Stateless
@Remote(KoordinateInterface.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class KoordinateBean implements KoordinateInterface, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "SwArch Praktikum")
	private EntityManager manager;
	@Resource
	private SessionContext ejbContext;


	@SuppressWarnings("unchecked")
	public List<Koordinate> getKoordinateList() throws NoSuchEntityException {
		return manager.createQuery("select o from Koordinate o").getResultList();
	}

	public Koordinate getKoordinate(int key) {
		Koordinate obj = manager.find(Koordinate.class, key);
		if (obj == null) {
			throw new NoSuchEntityException();
		} else
			return obj;
	}
}
