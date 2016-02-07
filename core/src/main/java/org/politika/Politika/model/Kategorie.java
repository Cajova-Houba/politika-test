package org.politika.Politika.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.politika.Politika.generic.model.BaseObject;
import org.politika.Politika.model.enums.KatTyp;

/**
 * Category is considered to be main if it doesn't have any parent category.
 * @author Zdenda
 *
 */
@Entity
public class Kategorie extends BaseObject {

	
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private KatTyp typ;
	
	@Column(length=50)
	private String nazev;
	
	@OneToMany(mappedBy="kategorie", fetch=FetchType.EAGER)
	private List<Prispevek> prispevky;
	
	@ManyToOne
	@JoinColumn(name="rodKategorie_id")
	private Kategorie rodicovskaKategorie;
	
	@OneToMany(mappedBy="rodicovskaKategorie", fetch=FetchType.EAGER)
	private List<Kategorie> subkategorie;
	
	@ManyToMany
	@JoinTable(
			name="kategorie_osoba",
			joinColumns={@JoinColumn(name="kategorie_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="osoba_id",referencedColumnName="id")}
			)
	private List<Osoba> osoby;
	
	public Kategorie() {
		super();
		setTyp(KatTyp.Normal);
	}
	
	public List<Osoba> getOsoby() {
		return osoby;
	}

	public void setOsoby(List<Osoba> osoby) {
		this.osoby = osoby;
	}

	public KatTyp getTyp() {
		return typ;
	}

	public void setTyp(KatTyp typ) {
		this.typ = typ;
	}

	public String getNazev() {
		return nazev;
	}

	public void setNazev(String nazev) {
		this.nazev = nazev;
	}

	public List<Prispevek> getPrispevky() {
		return prispevky;
	}

	public void setPrispevky(List<Prispevek> prispevky) {
		this.prispevky = prispevky;
	}
	
	public Kategorie getRodicovskaKategorie() {
		return rodicovskaKategorie;
	}

	public void setRodicovskaKategorie(Kategorie rodicovskaKategorie) {
		this.rodicovskaKategorie = rodicovskaKategorie;
	}

	public List<Kategorie> getSubkategorie() {
		return subkategorie;
	}

	public void setSubkategorie(List<Kategorie> subkategorie) {
		this.subkategorie = subkategorie;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Kategorie: [id=%d,nazev=%s,rodKatId=%d,typ=%s]", getId(),
				getNazev(),
				getRodicovskaKategorie()==null?0:getRodicovskaKategorie().getId(),
				getTyp().name());
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
