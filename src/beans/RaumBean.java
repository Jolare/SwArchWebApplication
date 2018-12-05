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

import model.Raum;

@Stateless
@Remote(RaumInterface.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class RaumBean implements RaumInterface, java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "SwArch Praktikum")
	private EntityManager manager;
	@Resource
	private SessionContext ejbContext;


	@SuppressWarnings("unchecked")
	public List<Raum> getRaeume() throws NoSuchEntityException {
		return manager.createQuery("SELECT o FROM Raum o").getResultList();
	}

	public Raum getRaum(int key) {
		Raum obj = manager.find(Raum.class, key);
		if (obj == null) {
			throw new NoSuchEntityException();
		} else
			return obj;
	}
}
