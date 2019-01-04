package servlets;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.ProduktionInterface;
import model.Produktion;

@ManagedBean(name = "production")
@SessionScoped
public class ProduktionManagedBean {
	public static final String EJBName = "java:global/SwArchWebApplication/ProduktionBean!beans.ProduktionInterface";

	@EJB(mappedName = EJBName)
	private ProduktionInterface prod;

	public List<Produktion> getProduktion() {
		return prod.getProduktionList();
	}
}
