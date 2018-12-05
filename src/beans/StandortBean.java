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

import model.Standort;

@Stateless
@Remote(StandortInterface.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class StandortBean implements StandortInterface, java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "SwArch Praktikum")
	private EntityManager manager;
	@Resource
	private SessionContext ejbContext;


	@SuppressWarnings("unchecked")
	public List<Standort> getStandorte() {
		return manager.createQuery("select o from Standort o").getResultList();
	}

	public Standort getStandort(int key) {
		Standort standort = manager.find(Standort.class, key);
		if (standort == null) {
			throw new NoSuchEntityException();
		} else
			return standort;
	}
}
