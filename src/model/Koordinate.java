package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="swarch_koordinate")
public class Koordinate implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int id;

	@Column(name="laengengrad")
	private float laengengrad;
	
	@Column(name="breitengrad")
	private float breitengrad;
	
	@ManyToOne
	@JoinColumn(name="raum_id")
	private Raum raum;
	
	public Koordinate(){}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLaengengrad() {
		return laengengrad;
	}

	public void setLaengengrad(float laengengrad) {
		this.laengengrad = laengengrad;
	}

	public float getBreitengrad() {
		return breitengrad;
	}

	public void setBreitengrad(float breitengrad) {
		this.breitengrad = breitengrad;
	}

	public Raum getRaum() {
		return raum;
	}

	public void setRaum(Raum raum) {
		this.raum = raum;
	}
}
