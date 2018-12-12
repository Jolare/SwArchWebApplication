package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="swarch_produktion")
public class Produktion implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="datum")
	private Date datum;
	
	@ManyToOne
	@JoinColumn(name="maschine_id")
	private Maschine maschine;
	
	@Column(name="nummer")
	private int nummer;
	
	public Produktion(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Maschine getMaschine() {
		return maschine;
	}

	public void setMaschine(Maschine maschine) {
		this.maschine = maschine;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
}
