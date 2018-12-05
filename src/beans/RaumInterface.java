package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Raum;

@Remote
public interface RaumInterface {
	List<Raum> getRaeume();

	Raum getRaum(int key);
}
