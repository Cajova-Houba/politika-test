package org.politika.Politika.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.politika.Politika.generic.model.BaseObject;

@Entity
public class Prispevek extends BaseObject {

	private static final long serialVersionUID = 1L;
	private Date datum;
	
	@Column(length=30)
	private String nadpis;
	
	@Lob
	@Column(length=512)
	private String text;
	
	@Column(columnDefinition = "TEXT")
	private String zdroje;
	
	@ManyToOne
	@JoinColumn(name="kategorie_id")
	private Kategorie kategorie;
	
	@ManyToMany(mappedBy="prispevky")
	private List<Osoba> osoby;
	
	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	public List<Osoba> getOsoby() {
		return osoby;
	}

	public void setOsoby(List<Osoba> osoby) {
		this.osoby = osoby;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNadpis() {
		return nadpis;
	}

	public void setNadpis(String nadpis) {
		this.nadpis = nadpis;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getZdroje() {
		return zdroje;
	}

	public void setZdroje(String zdroje) {
		this.zdroje = zdroje;
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
