package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="swarch_maschine")
public class Maschine implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="raum_id")
	private Raum raum;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="mitarbeiter_id")
	private Mitarbeiter mitarbeiter;
	
	public Maschine(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Raum getRaum() {
		return raum;
	}

	public void setRaum(Raum raum) {
		this.raum = raum;
	}

	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

}
