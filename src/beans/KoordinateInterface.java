package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Koordinate;

@Remote
public interface KoordinateInterface {
	List<Koordinate> getKoordinateList();

	Koordinate getKoordinate(int key);
}
