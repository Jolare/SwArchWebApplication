package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Standort;

@Remote
public interface StandortInterface {
	List<Standort> getStandorte();

	Standort getStandort(int key);
}
