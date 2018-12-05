package model;

import java.awt.Polygon;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="swarch_raum")
public class Raum implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gebaude_id")
	private Gebaude gebaude;
	
	@Column(name="bereich")
	private Polygon bereich;
	
	public Raum(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gebaude getGebaude() {
		return gebaude;
	}

	public void setGebaude(Gebaude gebaude) {
		this.gebaude = gebaude;
	}

	public Polygon getBereich() {
		return bereich;
	}

	public void setBereich(Polygon bereich) {
		this.bereich = bereich;
	}
}
