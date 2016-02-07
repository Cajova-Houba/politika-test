package org.politika.Politika.service;

import java.util.List;

import org.politika.Politika.generic.service.GenericManager;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Prispevek;

public interface PrispevekManager extends GenericManager<Prispevek, Long> {

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
