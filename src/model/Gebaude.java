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
@Table(name="swarch_gebaude")
public class Gebaude implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="standort_id")
	private Standort standort;
	
	public Gebaude(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Standort getStandort() {
		return standort;
	}

	public void setStandort(Standort standort) {
		this.standort = standort;
	}
}
