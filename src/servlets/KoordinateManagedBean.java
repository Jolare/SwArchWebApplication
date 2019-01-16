package servlets;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.KoordinateInterface;
import model.Koordinate;
import model.Raum;

import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;
import java.io.Console;
import java.util.List;

import javax.ejb.EJB;

@ManagedBean(name = "coordinate")
@SessionScoped
public class KoordinateManagedBean {
	private double x;
	private double y;

	public static final String EJBName = "java:global/SwArchWebApplication/KoordinateBean!beans.KoordinateInterface";
	
	@EJB(mappedName = EJBName)
	private KoordinateInterface koord;
	
//	public Raum getRaumSimple(double x, double y) {
//		List<Koordinate> list = koord.getKoordinateList();
//		
//	}
	
	public Raum getRaum(double x, double y) {
		System.out.println(x);
		System.out.println(y);
		Raum raum = null;
		int points = 1;
		List<Koordinate> list = koord.getKoordinateList();
		Path2D polygon = new Path2D.Double();
		double latitude = list.get(0).getBreitengrad();
		double longitude = list.get(0).getLaengengrad();
		polygon.moveTo(list.get(0).getBreitengrad(), list.get(0).getLaengengrad());
		int id = list.get(0).getRaum().getId();
		int roomCount = 0;
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i) == null) {
				System.out.println("leer");
			}
			System.out.println(list.get(i).getId());
		}
		while(roomCount < (list.size() / 4)) {
			for (int i = 1; i < list.size(); i++) {
				if(polygon.getCurrentPoint().getX() == list.get(i).getBreitengrad() && polygon.getCurrentPoint().getY() == list.get(i).getLaengengrad()) {
					continue;
				}
				if(list.get(i).getRaum().getId() == id) {
					polygon.lineTo(list.get(i).getBreitengrad(), list.get(i).getLaengengrad());
					points++;
					if (raum == null) {
						raum = list.get(i).getRaum();
					}
				}
				if (points == 4 && roomCount == (list.size()/4)-1) {
					polygon.lineTo(latitude, longitude);
					roomCount++;
					if(polygon.contains(x, y)) {
						return raum;
					} else {
						return null;
					}
				}
				if (points == 4 && id != list.get(i).getRaum().getId()) {
					polygon.lineTo(latitude, longitude);
					roomCount++;
					if(polygon.contains(x, y)) {
						return raum;
					}
					raum = null;
					points = 1;
					id = list.get(i).getRaum().getId();
					polygon.reset();
					latitude = list.get(i).getBreitengrad();
					longitude = list.get(i).getLaengengrad();
					polygon.moveTo(latitude, longitude);
					break;
				}
			}
		}
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

}
