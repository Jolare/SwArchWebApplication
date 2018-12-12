package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Maschine;

@Remote
public interface MaschineInterface {

	List<Maschine> getMaschineList();

	Maschine getMaschine(int key);
}
