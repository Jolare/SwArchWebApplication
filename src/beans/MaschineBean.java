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

import model.Maschine;

@Stateless
@Remote(MaschineInterface.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class MaschineBean implements MaschineInterface, java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "SwArch Praktikum")
	private EntityManager manager;

	@Resource
	private SessionContext ejbContext;

	@SuppressWarnings("unchecked")
	public List<Maschine> getMaschineList() {
		return manager.createQuery("select o from Maschine o").getResultList();
	}

	public Maschine getMaschine(int key) {
		Maschine obj = manager.find(Maschine.class, key);
		if (obj == null) {
			throw new NoSuchEntityException();
		} else
			return obj;
	}
}
