package org.politika.Politika.service;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.politika.Politika.generic.service.BaseManagerTestCase;
import org.politika.Politika.model.Prispevek;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;

public class PrispevekManagerTest extends BaseManagerTestCase {

	@Autowired
	@Qualifier("prispevekManager")
	private PrispevekManager prispevekManager;
	
	@Test
	public void testGetAll() {
		//v kategorii s id 4 jsou prispevky
		long kategorieId = 4l;
		List<Prispevek> prispevky = prispevekManager.getAll(kategorieId);
		
		assertFalse(prispevky.isEmpty());
	}
}
