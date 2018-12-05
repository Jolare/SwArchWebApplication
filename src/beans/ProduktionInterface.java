package beans;

import model.Maschine;
import model.Produktion;

import java.sql.Date;
import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.Remove;

@Remote
public interface ProduktionInterface {
	void insert(Date datum, Maschine maschine, int nummer);
	
	@Remove
	void checkout();
	
	Collection<Produktion> getProduktionList();
	
	Produktion getProduktion(int key);
}
