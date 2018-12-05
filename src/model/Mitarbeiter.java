package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="swarch_mitarbeiter")
public class Mitarbeiter implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="vorname")
	private String vorname;
	
	@Column(name="nachname")
	private String nachname;
	
	public Mitarbeiter(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
}
