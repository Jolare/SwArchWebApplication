package beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.NoSuchEntityException;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.Maschine;
import model.Produktion;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@Remote(ProduktionInterface.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class ProduktionBean implements ProduktionInterface, java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "SwArch Praktikum")
	private EntityManager manager;
	private Produktion produktion;
	private Collection<Produktion> produktionList = new ArrayList<Produktion>();
	@Resource
	private SessionContext ejbContext;
	
	public void insert(Date datum, Maschine maschine, int nummer){
		produktion = new Produktion();
		produktion.setDatum(datum);
		produktion.setMaschine(maschine);
		produktion.setNummer(nummer);
	}
	
	@Remove
	public void checkout(){
		UserTransaction ut = ejbContext.getUserTransaction();
		try {
			ut.begin();
			for (Produktion p : produktionList) {
				manager.persist(p);
			}
		} catch(IllegalStateException | NotSupportedException | SystemException | RollbackException eex) {
			eex.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Produktion> getProduktionList(){
		return manager.createQuery("select o from Produktion o").getResultList();
	}
	
	public Produktion getProduktion(int key) {
		Produktion obj = manager.find(Produktion.class, key);
		if (obj == null) {
			throw new NoSuchEntityException();
		} else
			return obj;
	}
}
