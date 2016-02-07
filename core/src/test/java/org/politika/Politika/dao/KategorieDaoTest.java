package org.politika.Politika.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.politika.Politika.generic.dao.BaseDaoTestCase;
import org.politika.Politika.generic.dao.GenericDao;
import org.politika.Politika.model.Kategorie;
import org.politika.Politika.model.Osoba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class KategorieDaoTest extends BaseDaoTestCase {

	@Autowired
	@Qualifier("kategorieDao")
	private KategorieDao kategorieDao;
	
	@Test
	public void testGetAll() {
		//v databazi by mely byt nejake kategorie
		List<Kategorie> kategorie = kategorieDao.getAll();
		
		assertFalse(kategorie.isEmpty());
	}
	
	@Test
	public void testGetAllMain() {
		//v databazi jsou main kategorie
		List<Kategorie> kategorie = kategorieDao.getAllMain();
		
		assertFalse(kategorie.isEmpty());
	}
	
	@Test
	public void testGetPersons() {
		//kategorii 7 jsou prirazeny osoby
		long kategorieId = 7l;
		List<Osoba> osoby = kategorieDao.getAllPersons(kategorieId);
		
		assertFalse(osoby.isEmpty());
	}
}
