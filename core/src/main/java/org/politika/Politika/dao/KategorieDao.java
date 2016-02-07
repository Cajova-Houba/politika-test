package org.politika.Politika.dao;

import java.util.List;

import org.politika.Politika.generic.dao.GenericDao;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Osoba;

public interface KategorieDao extends GenericDao<Kategorie, Long> {

	/*
	 * Returns a list of all main categories.
	 * 
	 */
	public List<Kategorie> getAllMain();
	
	public List<Osoba> getAllPersons(long kategorieId);
}
