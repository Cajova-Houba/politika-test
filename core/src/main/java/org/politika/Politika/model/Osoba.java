package org.politika.Politika.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.politika.Politika.generic.model.BaseObject;
import org.politika.Politika.model.enums.Funkce;

@Entity
public class Osoba extends BaseObject {

	private static final long serialVersionUID = 1L;

	@Lob
	@Column(length=512)
	private String info;
	
	@Column(length=50)
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable (
			name="osoba_prispevek",
			joinColumns={@JoinColumn(name="osoba_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="prispevek_id",referencedColumnName="id")}
			)
	private List<Prispevek> prispevky;
	
	@ManyToMany(mappedBy="osoby")
	private List<Kategorie> kategorie;
	
	@Enumerated(EnumType.STRING)
	private Funkce funkce;
	
	public Osoba() {
		
	}
	
	public List<Kategorie> getKategorie() {
		return kategorie;
	}

	public void setKategorie(List<Kategorie> kategorie) {
		this.kategorie = kategorie;
	}

	public Funkce getFunkce() {
		return funkce;
	}

	public void setFunkce(Funkce funkce) {
		this.funkce = funkce;
	}

	public Osoba(String name, String info) {
		this.name = name;
		this.info = info;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Prispevek> getPrispevky() {
		return prispevky;
	}

	public void setPrispevky(List<Prispevek> prispevky) {
		this.prispevky = prispevky;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
