package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Koordinate;
@ManagedBean(name = "coordinatetest")
@SessionScoped
public class test {
	public final static String EJBName = "java:global/SwArchWebApplication/KoordinateBean!beans.KoordinateInterface";
	@EJB(mappedName = EJBName)
	private static KoordinateInterface koordi;
	public static void main(String[] args) {
		List<Koordinate> list = koordi.getKoordinateList();
		for (Koordinate k : list) {
			System.out.println(k.getBreitengrad()+", " + k.getLaengengrad());
		}
	}
}
