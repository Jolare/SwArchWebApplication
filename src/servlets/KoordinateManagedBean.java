package servlets;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.KoordinateInterface;
import model.Koordinate;
import model.Raum;

import java.awt.Polygon;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

@ManagedBean(name = "coordinate")
@SessionScoped
public class KoordinateManagedBean {
	private double x;
	private double y;

	private Raum currentRaum;
	private String currentRaumString = "Sie befinden sich in keinem Raum";

	public static final String EJBName = "java:global/SwArchWebApplication/KoordinateBean!beans.KoordinateInterface";
	
	@EJB(mappedName = EJBName)
	private KoordinateInterface koord;
	
//	public Raum getRaumSimple(double x, double y) {
//		List<Koordinate> list = koord.getKoordinateList();
//		
//	}
	
	public Raum getRaum() {
		System.out.println(x);
		System.out.println(y);
		Raum raum = null;
		
		int posx = (int)(x * 1000000);
		int posy = (int)(y * 1000000);

		System.out.println(posx);
		System.out.println(posy);
		
		List<Koordinate> koordlist = koord.getKoordinateList();
		List<Integer> checkedraum = new ArrayList<Integer>();
		int selectedraum;
		
		Polygon polygon;
		
		for(Koordinate kk:koordlist){
			selectedraum = kk.getRaum().getId();
			if(checkedraum.contains(selectedraum)) continue;
			
			System.out.println("Check Raum "+selectedraum);
			
			polygon = new Polygon();
			
			for(Koordinate k: koordlist){
				if(k.getRaum().getId()==selectedraum){
					System.out.println(k.getLaengengrad()+" "+k.getBreitengrad());
					polygon.addPoint(
							(int)(k.getLaengengrad()*1000000),
							(int)(k.getBreitengrad()*1000000)
							);
				}
			}
			if(polygon.contains(posx,posy))
				raum = kk.getRaum();
			
			checkedraum.add(selectedraum);
		}

		if(raum!=null)
			setCurrentRaumString("Raum "+raum.getId()+" Gebäude "+raum.getGebaude().getName()+" "+raum.getGebaude().getStandort().getPlz()+" "+raum.getGebaude().getStandort().getOrt()+" "+raum.getGebaude().getStandort().getStrasse());
		else
			setCurrentRaumString("Sie befinden sich in keinem Raum");
		
		currentRaum = raum;
		return raum;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	

	public Raum getCurrentRaum() {
		return currentRaum;
	}

	public void setCurrentRaum(Raum currentRaum) {
		this.currentRaum = currentRaum;
	}

	public String getCurrentRaumString() {
		return currentRaumString;
	}

	public void setCurrentRaumString(String currentRaumString) {
		this.currentRaumString = currentRaumString;
	}

}
