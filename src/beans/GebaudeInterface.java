package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Gebaude;

@Remote
public interface GebaudeInterface {

	List<Gebaude> getGebaudeList();

	Gebaude getGebaude(int key);
}
