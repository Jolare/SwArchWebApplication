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

import model.Mitarbeiter;

@Stateless
@Remote(MitarbeiterInterface.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class MitarbeiterBean implements MitarbeiterInterface, java.io.Serializable{
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "SwArch Praktikum")
	private EntityManager manager;
	
	@Resource
	private SessionContext ejbContext;
	
	@SuppressWarnings("unchecked")
	public List<Mitarbeiter> getMitarbeiterList(){
		return manager.createQuery("select o from Mitarbeiter o").getResultList();
	}
	
	public Mitarbeiter getMitarbeiter(int key) {
		Mitarbeiter obj = manager.find(Mitarbeiter.class, key);
		if (obj == null) {
			throw new NoSuchEntityException();
		} else
			return obj;
	}
}
