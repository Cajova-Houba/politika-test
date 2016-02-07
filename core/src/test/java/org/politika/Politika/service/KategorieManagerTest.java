package org.politika.Politika.service;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.politika.Politika.generic.service.BaseManagerTestCase;
import org.politika.Politika.generic.service.GenericManager;
import org.politika.Politika.model.Kategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class KategorieManagerTest extends BaseManagerTestCase {

	@Autowired
	@Qualifier("kategorieManager")
	private KategorieManager kategorieManager;
	
	@Test
	public void testGetAll() {
		//v databazi by mely byt nejake kategorie
		List<Kategorie> kategorie = kategorieManager.getAll();
		
		assertFalse(kategorie.isEmpty());
	}
	
	@Test
	public void testGetAllMain() {
		//v databazi jsou main kategorie
		List<Kategorie> kategorie = kategorieManager.getAllMain();
		
		assertFalse(kategorie.isEmpty());
	}
}
