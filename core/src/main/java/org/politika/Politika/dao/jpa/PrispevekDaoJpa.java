package org.politika.Politika.dao.jpa;

import java.util.List;



import javax.persistence.Query;

import org.politika.Politika.dao.PrispevekDao;
import org.politika.Politika.generic.dao.jpa.GenericDaoJpa;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Prispevek;

public class PrispevekDaoJpa extends GenericDaoJpa<Prispevek, Long> implements
		PrispevekDao {

	public PrispevekDaoJpa() {
		super(Prispevek.class);
	}

	public List<Prispevek> getAll(Kategorie kategorie) {
		return getAll(kategorie.getId());
	}

	public List<Prispevek> getAll(long kategorieId) {
		String query = "SELECT prsp FROM "+getPersistentClass().getName()+" prsp WHERE kategorie_id=?";
		Query q = getEntityManager().createQuery(query);
		q.setParameter(1, kategorieId);
		
		return q.getResultList();
	}

	

}
