package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Mitarbeiter;

@Remote
public interface MitarbeiterInterface {
	
	public List<Mitarbeiter> getMitarbeiterList();
	public Mitarbeiter getMitarbeiter(int key);
}
