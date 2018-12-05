package beans;

import java.util.Collection;

import javax.ejb.Remote;

import model.Maschine;

@Remote
public interface MaschineInterface {

	Collection<Maschine> getMaschineList();

	Maschine getMaschine(int key);
}
