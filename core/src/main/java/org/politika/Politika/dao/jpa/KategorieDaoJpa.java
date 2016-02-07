package org.politika.Politika.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.politika.Politika.dao.KategorieDao;
import org.politika.Politika.generic.dao.jpa.GenericDaoJpa;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Osoba;

public class KategorieDaoJpa extends GenericDaoJpa<Kategorie, Long> implements
		KategorieDao {

	public KategorieDaoJpa() {
		super(Kategorie.class);
	}

	public List<Kategorie> getAllMain() {
		String query = "SELECT kat FROM Kategorie kat WHERE rodKategorie_id = NULL";
		Query q = getEntityManager().createQuery(query);
		return q.getResultList();
	}

	public List<Osoba> getAllPersons(long kategorieId) {
		String query = "SELECT os FROM Kategorie k JOIN k.osoby os where k.id=?";
		Query q = getEntityManager().createQuery(query);
		q.setParameter(1, kategorieId);
		return q.getResultList();
	}

}
