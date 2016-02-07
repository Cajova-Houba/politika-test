package org.politika.Politika.dao;

import java.util.List;

import org.politika.Politika.generic.dao.GenericDao;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Prispevek;

public interface PrispevekDao extends GenericDao<Prispevek, Long> {

	/**
	 * Vrátí všechny příspěvky v dané kategorii.
	 * @param kategorie
	 * @return
	 */
	public List<Prispevek> getAll(Kategorie kategorie);
	
	/**
	 * Vrátí všechny příspěvky v dané kategorii.
	 * @param kategorie
	 * @return
	 */
	public List<Prispevek> getAll(long kategorieId);
}
