package org.politika.Politika.service;

import java.util.List;

import org.politika.Politika.generic.service.GenericManager;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Osoba;

public interface KategorieManager extends GenericManager<Kategorie, Long> {

	/*
	 * Returns a list of all main categories.
	 * 
	 */
	public List<Kategorie> getAllMain();
	
	public List<Osoba> getAllPersons(long kategorieId);
}
