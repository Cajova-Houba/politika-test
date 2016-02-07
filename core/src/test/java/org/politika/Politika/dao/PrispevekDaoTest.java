package org.politika.Politika.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.politika.Politika.generic.dao.BaseDaoTestCase;
import org.politika.Politika.model.Prispevek;
import org.springframework.beans.factory.annotation.Autowired;

public class PrispevekDaoTest extends BaseDaoTestCase {

	@Autowired
	private PrispevekDao prispevekDao;
	
	@Test
	public void testGetAll() {
		//v kategorii s id 4 jsou prispevky
		long kategorieId = 4l;
		List<Prispevek> prispevky = prispevekDao.getAll(kategorieId);
		
		assertFalse(prispevky.isEmpty());
	}
}
