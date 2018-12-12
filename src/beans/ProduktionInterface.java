package beans;

import model.Maschine;
import model.Produktion;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface ProduktionInterface {
	void insert(Date datum, Maschine maschine, int nummer);
	
	@Remove
	void checkout();
	
	List<Produktion> getProduktionList();
	
	Produktion getProduktion(int key);
}
