package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@ManyToOne
	@JoinColumn(name="gebaude_id")
	private Gebaude gebaude;
	
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
}
