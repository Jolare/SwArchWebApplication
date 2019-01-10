package servlets;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.KoordinateInterface;
import model.Koordinate;
import model.Raum;

import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Double;
import java.util.List;

import javax.ejb.EJB;

@ManagedBean(name = "coordinate")
@SessionScoped
public class KoordinateManagedBean {

	public static final String EJBName = "java:global/SwArchWebApplication/KoordinateBean!beans.KoordinateInterface";
	
	@EJB(mappedName = EJBName)
	private KoordinateInterface koord;
	
	public Raum getRaum(double x, double y) {
		Raum raum = null;
		int points = 1;
		List<Koordinate> list = koord.getKoordinateList();
		Path2D polygon = new Path2D.Double();
		double latitude = list.get(0).getBreitengrad();
		double longitude = list.get(0).getLaengengrad();
		polygon.moveTo(list.get(0).getBreitengrad(), list.get(0).getLaengengrad());
		int id = list.get(0).getRaum().getId();
		int roomCount = 0;
		while(roomCount < list.size() / 4) {
			for (int i = 1; i < list.size(); i++) {
				if(polygon.getCurrentPoint().getX() == list.get(i).getBreitengrad() && polygon.getCurrentPoint().getY() == list.get(i).getLaengengrad()) {
					continue;
				}
				if(list.get(i).getRaum().getId() == id) {
					polygon.lineTo(list.get(i).getBreitengrad(), list.get(i).getLaengengrad());
					points++;
					raum = list.get(i).getRaum();
				}
				if (points == 4 && id != list.get(i).getRaum().getId()) {
					polygon.lineTo(latitude, longitude);
					if(polygon.contains(x, y)) {
						return raum;
					}
					raum = null;
					roomCount++;
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
}
