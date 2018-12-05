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

import model.Gebaude;

@Stateless
@Remote(GebaudeInterface.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class GebaudeBean implements GebaudeInterface, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "SwArch Praktikum")
	private EntityManager manager;

	@Resource
	private SessionContext ejbContext;

	@SuppressWarnings("unchecked")
	public List<Gebaude> getGebaudeList() {
		return manager.createQuery("select o from Gebaude o").getResultList();
	}

	public Gebaude getGebaude(int key) {
		Gebaude obj = manager.find(Gebaude.class, key);
		if (obj == null) {
			throw new NoSuchEntityException();
		} else
			return obj;
	}
}
